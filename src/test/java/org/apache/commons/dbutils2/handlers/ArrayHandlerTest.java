/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.dbutils2.handlers;

import java.sql.SQLException;

import org.apache.commons.dbutils2.BaseTestCase;
import org.apache.commons.dbutils2.ResultSetHandler;
import org.apache.commons.dbutils2.handlers.ArrayHandler;

/**
 * ArrayHandlerTest
 */
public class ArrayHandlerTest extends BaseTestCase {

    public void testHandle() throws SQLException {
        ResultSetHandler<Object[]> h = new ArrayHandler<Object>();
        Object[] results = h.handle(this.rs);

        assertNotNull(results);
        assertEquals(COLS, results.length);
        assertEquals("1", results[0]);
        assertEquals("2", results[1]);
        assertEquals("3", results[2]);
    }

    public void testEmptyResultSetHandle() throws SQLException {
        ResultSetHandler<Object[]> h = new ArrayHandler<Object>();
        Object[] results = h.handle(this.emptyResultSet);

        assertNull(results);
    }

}
