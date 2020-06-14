package subatomic

import java.util.concurrent.atomic.AtomicReference as JavaAtomicReference

/**
 * Atomic operations backed by the JVM's Atomic Reference class.
 */
actual class AtomicReference<T> actual constructor(initial: T) {
    private val backingReference = JavaAtomicReference(initial)

    actual var value: T
        get() = backingReference.get()
        set(newValue) { backingReference.set(newValue) }

    actual fun lazySet(newValue: T) {
        backingReference.lazySet(newValue)
    }
}
