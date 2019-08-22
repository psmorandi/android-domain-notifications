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
    fun test_for_inheritance() {
        val inheritanceTestClass = InheritanceTestClass()

        inheritanceTestClass.demonstrate()

        Assert.assertFalse(inheritanceTestClass.success())
        Assert.assertTrue(inheritanceTestClass.messages().isNotEmpty())
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
    }

    class InheritanceTestClass : ExecutionResult() {
        fun demonstrate() {
            this.addMessage("test", "Some random text")
        }
    }
}