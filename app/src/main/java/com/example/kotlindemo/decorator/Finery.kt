package com.example.kotlindemo.decorator

/**
 * Decorator
 */
open class Finery : Person() {

    private var component: Person? = null

    fun decorate(component: Person) {
        this.component = component
    }

    override fun show() {
        component?.show()
    }
}