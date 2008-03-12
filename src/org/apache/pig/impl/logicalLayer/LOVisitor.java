/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pig.impl.logicalLayer;

import java.util.List;
import java.util.Iterator;

import org.apache.pig.impl.plan.PlanVisitor;
import org.apache.pig.impl.logicalLayer.parser.ParseException;


/**
 * A visitor mechanism for navigating and operating on a tree of Logical
 * Operators.  This class contains the logic to navigate thre tree, but does
 * not do anything with or to the tree.  In order to operate on or extract
 * information from the tree, extend this class.  You only need to implement
 * the methods dealing with the logical operators you are concerned
 * with.  For example, if you wish to find every LOEval in a logical plan
 * and perform some operation on it, your visitor would look like:
 * class MyLOVisitor extends LOVisitor {
 *     public void visitEval(LOEval e) { you're logic here }
 * }
 * Any operators that you do not implement the visitX method for will then
 * be navigated through by this class.
 *
 * *NOTE* When envoking a visitor, you should never call one of the
 * methods in this class.  You should pass your visitor as an argument to
 * visit() on the object you want to visit.  So:
 * RIGHT:  LOEval myEval; MyVisitor v; myEval.visit(v);
 * WRONG:  LOEval myEval; MyVisitor v; v.visitEval(myEval);
 * These methods are only public to make them accessible to the LO* objects.
 */
abstract public class LOVisitor extends PlanVisitor {

    public LOVisitor(LogicalPlan plan) {
        super(plan);
    }

    void visitCogroup(LOCogroup cg) throws ParseException {
    }

    void visitEval(LOEval e) throws ParseException {
        // Don't worry about visiting the contained logical operators, as the logical
        // operators in it are already contained in the outer plan.
    }

    void visitGenerate(LOGenerate g) throws ParseException {
        // Visit each of generates projection elements.
        Iterator<LogicalOperator> i = g.getProjections().iterator();
        while (i.hasNext()) {
            i.next().visit(this);
        }
    }
        
    void visitSort(LOSort s) throws ParseException {
    }

    void visitUserFunc(LOUserFunc func) throws ParseException {
        // Visit each of the arguments
        Iterator<ExpressionOperator> i = func.getArguments().iterator();
        while (i.hasNext()) {
            i.next().visit(this);
        }
    }
}

        
