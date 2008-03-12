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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.pig.impl.logicalLayer.parser.ParseException;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.pig.impl.plan.PlanVisitor;


public class LOCogroup extends LogicalOperator {
    private static final long serialVersionUID = 2L;

    public LOCogroup(LogicalPlan plan, OperatorKey k) { 
        super(plan, k, -1);
    }

    @Override
    public String name() {
        return "CoGroup " + mKey.scope + "-" + mKey.id;
    }

    @Override
    public String typeName() {
        return "LOCogroup";
    }

    @Override
    public boolean supportsMultipleInputs() {
        return true;
    }

    @Override
    public boolean supportsMultipleOutputs() {
        return false;
    }

    @Override
    public Schema getSchema() {
        // TODO create schema
        return null;
    }

    @Override
    public void visit(PlanVisitor v) throws ParseException {
        if (!(v instanceof LOVisitor)) {
            throw new RuntimeException("You can only visit LogicalOperators "
                + "with an LOVisitor!");
        }
        ((LOVisitor)v).visitCogroup(this);
    }

}
