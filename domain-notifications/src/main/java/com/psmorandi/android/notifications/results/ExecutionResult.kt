package com.psmorandi.android.notifications.results

import com.psmorandi.android.notifications.Notification

/**
 * Class that represents if the execution result was successful or not without caring about the value returned from the execution.
 */
class ExecutionResult {
    private val response = Response("")

    fun success() = !this.response.hasMessages()
    fun messages() = this.response.messages()

    fun addMessage(property: String, message: String) {
        this.response.addNotificationMessage(Notification(property, message))
    }

    fun addMessage(notification: Notification) {
        this.response.addNotificationMessage(notification)
    }

    override fun toString() = this.response.toString()
}