/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * 
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 * 
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 * 
 * Contributor(s):
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
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 * US Government Users Restricted Rights - Use, duplication or
 * disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

package com.sun.corba.se.impl.corba;

import org.omg.CORBA.Any;
import org.omg.CORBA.Context;
import org.omg.CORBA.NVList;

import com.sun.corba.se.spi.logging.ORBUtilSystemException ;

public final class ContextImpl extends Context {
    private static final ORBUtilSystemException wrapper =
        ORBUtilSystemException.self ;

    private org.omg.CORBA.ORB _orb;

    public ContextImpl(org.omg.CORBA.ORB orb) 
    {
        _orb = orb;
    }

    public ContextImpl(Context parent) 
    {
        // Ignore: no wrapper available
    }
    
    public String context_name() 
    {
	throw wrapper.contextNotImplemented() ;
    }

    public Context parent() 
    {
	throw wrapper.contextNotImplemented() ;
    }

    public Context create_child(String name) 
    {
	throw wrapper.contextNotImplemented() ;
    }

    public void set_one_value(String propName, Any propValue) 
    {
	throw wrapper.contextNotImplemented() ;
    }

    public void set_values(NVList values) 
    {
	throw wrapper.contextNotImplemented() ;
    }


    public void delete_values(String propName) 
    {
	throw wrapper.contextNotImplemented() ;
    }

    public NVList get_values(String startScope, 
			     int opFlags, 
			     String propName) 
    {
	throw wrapper.contextNotImplemented() ;
    }
};

