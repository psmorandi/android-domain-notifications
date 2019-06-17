package com.psmorandi.android.notifications

/**
 * Abstract class to make a domain model notifiable.
 */
abstract class Notifiable protected constructor() {

    private val notifications = mutableListOf<Notification>()

    fun getNotifications() = notifications.toList()

    fun addNotification(property: String, message: String) {
        this.notifications.add(Notification(property, message))
    }

    fun addNotification(notification: Notification) {
        this.notifications.add(notification)
    }

    fun addNotifications(notifications: List<Notification>) {
        this.notifications.addAll(notifications)
    }

    fun addNotifications(notifiable: Notifiable) {
        this.notifications.addAll(notifiable.getNotifications())
    }

    fun invalid() = this.notifications.isNotEmpty()
    fun valid() = !invalid()
}