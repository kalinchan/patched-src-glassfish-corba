/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2000-2007 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package corba.framework.junitreport;

import java.io.OutputStream;

import java.util.Properties ;

import com.sun.corba.se.spi.orbutil.generic.Pair ;
import com.sun.corba.se.spi.orbutil.generic.Triple ;

/**
 * This Interface describes classes that format the results of a JUnit
 * testrun.
 *
 */
public interface JUnitReportWriter {
    public class TestDescription extends Pair<String,String> {
	public TestDescription( String name, String className ) {
            super( name, className ) ;
	}

	public String getName() {
	    return first() ;
	}

	public String getClassName() {
	    return second() ;
	}

        public String toString() {
            return getClassName() + "." + getName() ;
        }
    }
    
    public class TestCounts extends Triple<Integer,Integer,Integer> {
        public TestCounts( int pass, int fail, int error ) {
            super( pass, fail, error ) ;
        }

        public int pass() {
            return first() ;
        }

        public int fail() {
            return second() ;
        }

        public int error() {
            return third() ;
        }
    }

    /**
     * The whole testsuite started.
     * @param suite the suite.
     */
    void startTestSuite(String name, Properties props ) ;

    /**
     * Sets the stream the formatter is supposed to write its results to.
     * @param out the output stream to use.
     */
    void setOutput(OutputStream out);

    /**
     * This is what the test has written to System.out
     * @param out the string to write.
     */
    void setSystemOutput(String out);

    /**
     * This is what the test has written to System.err
     * @param err the string to write.
     */
    void setSystemError(String err);

    /**
     * A test started.
     */
    void startTest(TestDescription test);

    /**
     * An error occurred.
     */
    void addError(TestDescription test, Throwable t);

    /**
     * A failure occurred.
     */
    void addFailure(TestDescription test, Throwable t);  

    /**
     * A test ended.
     */
    void endTest(TestDescription test); 

    /** 
     * A test ended.  Here we supply the duration, in case the duration is not
     * determined by the [ startTest, endTest ] interval.
     */
    void endTest(TestDescription test, long duration ); 

    /**
     * The whole testsuite ended.
     * @param suite the suite.
     */
    TestCounts endTestSuite() ;
}
