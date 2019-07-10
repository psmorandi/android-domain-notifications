package com.psmorandi.android.notifications.results

import com.psmorandi.android.notifications.Notification
import org.junit.Assert
import org.junit.Test

/**
 * Test for execution results.
 */
class ExecutionResultUnitTests {
    @Test
    fun process_with_successful_result() {
        val bll = SomeBusinessClass()

        val result = bll.doSomeImportantProcessWith("this string")

        Assert.assertTrue(result.success())
    }

    @Test
    fun process_with_error_result() {
        val bll = SomeBusinessClass()

        val result = bll.doSomeImportantProcessWith("")

        Assert.assertFalse(result.success())
        Assert.assertTrue(result.messages().isNotEmpty())
    }

    @Test
    fun process_with_error_result_with_notification() {
        val bll = SomeBusinessClass()

        val result = bll.doAnotherImportantProcessWith("")

        Assert.assertFalse(result.success())
        Assert.assertTrue(result.messages().isNotEmpty())
    }

    @Test
    fun process_with_error_result_with_notifications() {
        val bll = SomeBusinessClass()

        val result = bll.doSomeProcessAfterResponseReceivedWithErrorReturn()

        Assert.assertFalse(result.success())
        Assert.assertTrue(result.messages().isNotEmpty())
        Assert.assertTrue(result.messages().size > 1)
    }

    class SomeBusinessClass {

        fun doSomeImportantProcessWith(parameter: String): ExecutionResult {

            val result = ExecutionResult()

            //parameter is required to be non empty
            if (parameter.isEmpty()) {
                result.addMessage("parameter", "Required field")
            }

            return result
        }

        fun doAnotherImportantProcessWith(parameter: String): ExecutionResult {

            val result = ExecutionResult()

            //parameter is required to be non empty
            if (parameter.isEmpty()) {
                result.addMessage(Notification("parameter", "Parameter is required"))
            }

            return result
        }

        fun doSomeProcessAfterResponseReceivedWithErrorReturn(): ExecutionResult {
            val result = ExecutionResult()

            val response = callSomethingThatReturnsResponse()

            if (response.hasMessages()) {
                result.addMessages(response.messages())
            }

            return result
        }

        private fun callSomethingThatReturnsResponse(): Response<String> {
            val response = Response<String>()

            response.addNotification("parameter", "error description")
            response.addNotification("parameter2", "another error description")
            response.addNotification("parameter3", "yet another error description")

            return response
        }
    }
}