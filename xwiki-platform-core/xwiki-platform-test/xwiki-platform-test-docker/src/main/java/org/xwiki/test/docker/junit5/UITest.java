/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.test.docker.junit5;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Marks a test as being a functional UI Test.
 *
 * @version $Id$
 * @since 10.6RC1
 */
@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD, ANNOTATION_TYPE })
@ExtendWith(XWikiDockerExtension.class)
public @interface UITest
{
    /**
     * @return the browser to use, see {@link Browser}
     */
    Browser browser() default Browser.SYSTEM;

    /**
     * @return the database to use, see {@link Database}
     * @since 10.9RC1
     */
    Database database() default Database.MYSQL;

    /**
     * @return the Servlet Engine to use, see {@link ServletEngine}
     * @since 10.9RC1
     */
    ServletEngine servletEngine() default ServletEngine.TOMCAT;

    /**
     * @return true if the test should be started in debug mode, false otherwise
     * @since 10.9RC1
     */
    boolean debug() default false;
}
