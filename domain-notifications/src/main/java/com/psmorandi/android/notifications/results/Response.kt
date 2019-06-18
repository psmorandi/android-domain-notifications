package com.psmorandi.android.notifications.results

import com.psmorandi.android.notifications.Notifiable
import com.psmorandi.android.notifications.Notification

/**
 * A class to return the value after a process in business layer or validation messages about what went wrong.
 */
class Response<T : Any?> : Notifiable {

    private var value: T? = null

    constructor(value: T) {
        this.value = value
    }

    constructor()

    /**
     * The result value for this response.
     */
    fun value() = value

    /**
     * Validation messages for the response.
     */
    fun messages() = this.getNotifications()

    /**
     * Indicates whether there is notification messages in the response.
     */
    fun hasMessages() = this.invalid()

    /**
     * Adds a new validation message for the response.
     */
    fun addNotificationMessage(notification: Notification) {
        this.addNotification(notification)
    }

    /**
     * Adds a list of validation messages for the response.
     */
    fun addNotificationMessage(notifications: List<Notification>) {
        this.addNotifications(notifications)
    }

    /**
     * Adds a result value for the response.
     */
    fun addValue(value: T) {
        this.value = value
    }

    override fun toString() =
        this.getNotifications().joinToString(separator = ",") { it.toString() }
}