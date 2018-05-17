package org.jetbrains.kotlin.gradle

import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
abstract class BaseMultiGradleVersionIT : BaseGradleIT() {
    @Parameter
    lateinit var gradleVersionString: String

    protected val gradleVersion get() = GradleVersionRequired.Exact(gradleVersionString)

    companion object {
        @JvmStatic
        @Parameters(name = "Test with Gradle version {0}")
        fun params() = listOf("3.5", "4.0").map { arrayOf(it) }
    }
}