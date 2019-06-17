package com.psmorandi.android.notifications

import org.junit.Assert
import org.junit.Test

/**
 * Notification unit tests.
 */
class NotifiableUnitTests : Notifiable() {
    @Test
    fun add_notification_property() {
        addNotification("prop", "message")

        Assert.assertTrue(getNotifications().size == 1)
        Assert.assertTrue(invalid())
        Assert.assertFalse(valid())
    }

    @Test
    fun add_notification_with_notification() {
        addNotification(Notification("prop", "message"))

        Assert.assertTrue(getNotifications().size == 1)
        Assert.assertTrue(invalid())
        Assert.assertFalse(valid())
    }

    @Test
    fun add_notification_with_notifiable() {
        val customer = Customer("first", "last")
        customer.addNotification("error", "not_valid")

        addNotifications(customer)

        Assert.assertTrue(getNotifications().size == 1)
        Assert.assertTrue(invalid())
        Assert.assertFalse(valid())
    }

    @Test
    fun add_notification_with_notification_list() {
        val customer = Customer("first", "last")
        customer.addNotification("error1", "not_valid")
        customer.addNotification("error2", "not_valid")
        customer.addNotification("error3", "not_valid")
        customer.addNotification("error4", "not_valid")
        customer.addNotification("error5", "not_valid")

        addNotifications(customer.getNotifications())

        Assert.assertTrue(getNotifications().size == 5)
        Assert.assertTrue(invalid())
        Assert.assertFalse(valid())
    }

    @Test
    fun notifiable_without_notification() {
        Assert.assertTrue(getNotifications().isEmpty())
        Assert.assertFalse(invalid())
        Assert.assertTrue(valid())
    }

    data class Customer(val firstName: String, val lasName: String) : Notifiable()
}