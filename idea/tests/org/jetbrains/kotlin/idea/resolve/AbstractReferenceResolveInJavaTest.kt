/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.resolve

import org.jetbrains.kotlin.idea.test.JdkAndMockLibraryProjectDescriptor
import org.jetbrains.kotlin.idea.test.PluginTestCaseBase

private val DIR = "/resolve/referenceInJava/dependency"
private val FILE_WITH_KOTLIN_CODE = PluginTestCaseBase.getTestDataPathBase() + DIR + "/dependencies.kt"

abstract class AbstractReferenceResolveInJavaTest : AbstractReferenceResolveTest() {
    override fun doTest(path: String) {
        assert(path.endsWith(".java")) { path }
        myFixture.configureByFile(FILE_WITH_KOTLIN_CODE)
        myFixture.configureByFile(path)
        performChecks()
    }
}

abstract class AbstractReferenceToCompiledKotlinResolveInJavaTest : AbstractReferenceResolveTest() {
    override fun doTest(path: String) {
        myFixture.configureByFile(path)
        performChecks()
    }

    override fun getProjectDescriptor() = JdkAndMockLibraryProjectDescriptor(FILE_WITH_KOTLIN_CODE, false)
}
