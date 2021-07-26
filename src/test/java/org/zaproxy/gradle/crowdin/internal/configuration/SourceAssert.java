/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2021 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.gradle.crowdin.internal.configuration;

import java.util.Objects;
import org.assertj.core.api.AbstractObjectAssert;
import org.assertj.core.internal.Iterables;

/** {@link Source} specific assertions - Generated by CustomAssertionGenerator. */
public class SourceAssert extends AbstractObjectAssert<SourceAssert, Source> {

    /**
     * Creates a new <code>{@link SourceAssert}</code> to make assertions on actual Source.
     *
     * @param actual the Source we want to make assertions on.
     */
    public SourceAssert(Source actual) {
        super(actual, SourceAssert.class);
    }

    /**
     * An entry point for SourceAssert to follow AssertJ standard <code>assertThat()</code>
     * statements.<br>
     * With a static import, one can write directly: <code>assertThat(mySource)</code> and get
     * specific assertion with code completion.
     *
     * @param actual the Source we want to make assertions on.
     * @return a new <code>{@link SourceAssert}</code>
     */
    @org.assertj.core.util.CheckReturnValue
    public static SourceAssert assertThat(Source actual) {
        return new SourceAssert(actual);
    }

    /**
     * Verifies that the actual Source's crowdinPath is equal to the given one.
     *
     * @param crowdinPath the given crowdinPath to compare the actual Source's crowdinPath to.
     * @return this assertion object.
     * @throws AssertionError - if the actual Source's crowdinPath is not equal to the given one.
     */
    public SourceAssert hasCrowdinPath(DirFilenamePair crowdinPath) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage =
                "\nExpecting crowdinPath of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        DirFilenamePair actualCrowdinPath = actual.getCrowdinPath();
        if (!Objects.deepEquals(actualCrowdinPath, crowdinPath)) {
            failWithMessage(assertjErrorMessage, actual, crowdinPath, actualCrowdinPath);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's dir is equal to the given one.
     *
     * @param dir the given dir to compare the actual Source's dir to.
     * @return this assertion object.
     * @throws AssertionError - if the actual Source's dir is not equal to the given one.
     */
    public SourceAssert hasDir(String dir) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage =
                "\nExpecting dir of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        String actualDir = actual.getDir();
        if (!Objects.deepEquals(actualDir, dir)) {
            failWithMessage(assertjErrorMessage, actual, dir, actualDir);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's exportPattern is equal to the given one.
     *
     * @param exportPattern the given exportPattern to compare the actual Source's exportPattern to.
     * @return this assertion object.
     * @throws AssertionError - if the actual Source's exportPattern is not equal to the given one.
     */
    public SourceAssert hasExportPattern(DirFilenamePair exportPattern) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage =
                "\nExpecting exportPattern of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        DirFilenamePair actualExportPattern = actual.getExportPattern();
        if (!Objects.deepEquals(actualExportPattern, exportPattern)) {
            failWithMessage(assertjErrorMessage, actual, exportPattern, actualExportPattern);
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's includes contains the given FileSet elements.
     *
     * @param includes the given elements that should be contained in actual Source's includes.
     * @return this assertion object.
     * @throws AssertionError if the actual Source's includes does not contain all given FileSet
     *     elements.
     */
    public SourceAssert hasIncludes(FileSet... includes) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // check that given FileSet varargs is not null.
        if (includes == null) failWithMessage("Expecting includes parameter not to be null.");

        // check with standard error message, to set another message call:
        // info.overridingErrorMessage("my error message");
        Iterables.instance().assertContains(info, actual.getIncludes(), includes);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's includes contains the given FileSet elements in Collection.
     *
     * @param includes the given elements that should be contained in actual Source's includes.
     * @return this assertion object.
     * @throws AssertionError if the actual Source's includes does not contain all given FileSet
     *     elements.
     */
    public SourceAssert hasIncludes(java.util.Collection<? extends FileSet> includes) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // check that given FileSet collection is not null.
        if (includes == null) {
            failWithMessage("Expecting includes parameter not to be null.");
            return this; // to fool Eclipse "Null pointer access" warning on toArray.
        }

        // check with standard error message, to set another message call:
        // info.overridingErrorMessage("my error message");
        Iterables.instance().assertContains(info, actual.getIncludes(), includes.toArray());

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's includes contains <b>only</b> the given FileSet elements
     * and nothing else in whatever order.
     *
     * @param includes the given elements that should be contained in actual Source's includes.
     * @return this assertion object.
     * @throws AssertionError if the actual Source's includes does not contain all given FileSet
     *     elements.
     */
    public SourceAssert hasOnlyIncludes(FileSet... includes) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // check that given FileSet varargs is not null.
        if (includes == null) failWithMessage("Expecting includes parameter not to be null.");

        // check with standard error message, to set another message call:
        // info.overridingErrorMessage("my error message");
        Iterables.instance().assertContainsOnly(info, actual.getIncludes(), includes);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's includes contains <b>only</b> the given FileSet elements in
     * Collection and nothing else in whatever order.
     *
     * @param includes the given elements that should be contained in actual Source's includes.
     * @return this assertion object.
     * @throws AssertionError if the actual Source's includes does not contain all given FileSet
     *     elements.
     */
    public SourceAssert hasOnlyIncludes(java.util.Collection<? extends FileSet> includes) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // check that given FileSet collection is not null.
        if (includes == null) {
            failWithMessage("Expecting includes parameter not to be null.");
            return this; // to fool Eclipse "Null pointer access" warning on toArray.
        }

        // check with standard error message, to set another message call:
        // info.overridingErrorMessage("my error message");
        Iterables.instance().assertContainsOnly(info, actual.getIncludes(), includes.toArray());

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's includes does not contain the given FileSet elements.
     *
     * @param includes the given elements that should not be in actual Source's includes.
     * @return this assertion object.
     * @throws AssertionError if the actual Source's includes contains any given FileSet elements.
     */
    public SourceAssert doesNotHaveIncludes(FileSet... includes) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // check that given FileSet varargs is not null.
        if (includes == null) failWithMessage("Expecting includes parameter not to be null.");

        // check with standard error message (use overridingErrorMessage before contains to set your
        // own message).
        Iterables.instance().assertDoesNotContain(info, actual.getIncludes(), includes);

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's includes does not contain the given FileSet elements in
     * Collection.
     *
     * @param includes the given elements that should not be in actual Source's includes.
     * @return this assertion object.
     * @throws AssertionError if the actual Source's includes contains any given FileSet elements.
     */
    public SourceAssert doesNotHaveIncludes(java.util.Collection<? extends FileSet> includes) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // check that given FileSet collection is not null.
        if (includes == null) {
            failWithMessage("Expecting includes parameter not to be null.");
            return this; // to fool Eclipse "Null pointer access" warning on toArray.
        }

        // check with standard error message (use overridingErrorMessage before contains to set your
        // own message).
        Iterables.instance().assertDoesNotContain(info, actual.getIncludes(), includes.toArray());

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source has no includes.
     *
     * @return this assertion object.
     * @throws AssertionError if the actual Source's includes is not empty.
     */
    public SourceAssert hasNoIncludes() {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // we override the default error message with a more explicit one
        String assertjErrorMessage =
                "\nExpecting :\n  <%s>\nnot to have includes but had :\n  <%s>";

        // check
        if (actual.getIncludes().iterator().hasNext()) {
            failWithMessage(assertjErrorMessage, actual, actual.getIncludes());
        }

        // return the current assertion for method chaining
        return this;
    }

    /**
     * Verifies that the actual Source's outputDir is equal to the given one.
     *
     * @param outputDir the given outputDir to compare the actual Source's outputDir to.
     * @return this assertion object.
     * @throws AssertionError - if the actual Source's outputDir is not equal to the given one.
     */
    public SourceAssert hasOutputDir(String outputDir) {
        // check that actual Source we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage =
                "\nExpecting outputDir of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        String actualOutputDir = actual.getOutputDir();
        if (!Objects.deepEquals(actualOutputDir, outputDir)) {
            failWithMessage(assertjErrorMessage, actual, outputDir, actualOutputDir);
        }

        // return the current assertion for method chaining
        return this;
    }
}