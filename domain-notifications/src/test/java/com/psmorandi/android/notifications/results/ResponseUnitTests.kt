package com.psmorandi.android.notifications.results

import com.psmorandi.android.notifications.Notification
import org.junit.Assert
import org.junit.Test

/**
 * Tests for response return.
 */
class ResponseUnitTests {

    @Test
    fun create_default_response_without_return_value() {

        val response = Response<String>()

        Assert.assertNull(response.value())
        Assert.assertFalse(response.hasMessages())
    }

    @Test
    fun create_response_valid_return_value() {

        val response = Response(Customer("first", "last"))

        Assert.assertNotNull(response.value())
        Assert.assertTrue(response.valid())

        Assert.assertTrue(response.value()?.firstName == "first")
        Assert.assertTrue(response.value()?.lastName == "last")

        Assert.assertFalse(response.hasMessages())
        Assert.assertFalse(response.invalid())
    }

    @Test
    fun create_response_with_notification() {

        val response = Response("some string")

        response.addNotificationMessage(Notification("parameter", "some string is invalid"))

        Assert.assertNotNull(response.value())
        Assert.assertFalse(response.valid())
        Assert.assertTrue(response.messages().size == 1)

        Assert.assertTrue(response.hasMessages())
        Assert.assertTrue(response.invalid())
    }

    @Test
    fun create_response_with_notification_list() {

        val response = Response("some string")

        val notifications = arrayListOf(
            Notification("prop", "message1"),
            Notification("prop2", "message2")
        )

        response.addNotificationMessage(notifications)

        Assert.assertNotNull(response.value())
        Assert.assertFalse(response.valid())
        Assert.assertTrue(response.messages().size == 2)

        Assert.assertTrue(response.hasMessages())
        Assert.assertTrue(response.invalid())
    }

    @Test
    fun create_response_and_set_return_value() {

        val response = Response<Customer>()

        response.addValue(Customer("first", "last"))

        Assert.assertNotNull(response.value())
        Assert.assertTrue(response.valid())

        Assert.assertTrue(response.value()?.firstName == "first")
        Assert.assertTrue(response.value()?.lastName == "last")

        Assert.assertFalse(response.hasMessages())
        Assert.assertFalse(response.invalid())
    }

    @Test
    fun test_for_inheritance() {
        val inheritanceTestClass = InheritanceTestClass<Customer>()

        inheritanceTestClass.demonstrate()

        Assert.assertTrue(inheritanceTestClass.invalid())
        Assert.assertTrue(inheritanceTestClass.messages().isNotEmpty())
    }

    private data class Customer(val firstName: String, val lastName: String)

    class InheritanceTestClass<Customer> : Response<Customer>() {
        fun demonstrate() {
            this.addNotification("test", "Some random text")
        }
    }
}