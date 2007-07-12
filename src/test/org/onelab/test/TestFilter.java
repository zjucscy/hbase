/**
 * Copyright (c) 2005, European Commission project OneLab under contract 034819
 * (http://www.one-lab.org)
 * 
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or 
 * without modification, are permitted provided that the following 
 * conditions are met:
 *  - Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in 
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of the University Catholique de Louvain - UCL
 *    nor the names of its contributors may be used to endorse or 
 *    promote products derived from this software without specific prior 
 *    written permission.
 *    
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT 
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS 
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
/**
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
package org.onelab.test;

import junit.framework.TestCase;

import org.onelab.filter.*;

/**
 * Test class.
 * 
 * contract <a href="http://www.one-lab.org">European Commission One-Lab Project 034819</a>.
 *
 * @version 1.0 - 8 Feb. 07
 */
public class TestFilter extends TestCase {
  
  /** Test a BloomFilter */
  public void testBloomFilter() {
    Filter bf = new BloomFilter(8, 2);
    Key key = new StringKey("toto");
    Key k2 = new StringKey("lulu");
    Key k3 = new StringKey("mama");
    bf.add(key);
    bf.add(k2);
    bf.add(k3);
    assertTrue(bf.membershipTest(key));
    assertFalse(bf.membershipTest(new StringKey("graknyl")));
    assertTrue(bf.membershipTest(new StringKey("xyzzy")));      // False positive
    assertTrue(bf.membershipTest(new StringKey("abcd")));       // False positive
  }
  
  /** Test a CountingBloomFilter */
  public void testCountingBloomFilter() {
    Filter bf = new CountingBloomFilter(8, 2);
    Key key = new StringKey("toto");
    Key k2 = new StringKey("lulu");
    Key k3 = new StringKey("mama");
    bf.add(key);
    bf.add(k2);
    bf.add(k3);
    assertTrue(bf.membershipTest(key));
    assertFalse(bf.membershipTest(new StringKey("graknyl")));
    assertTrue(bf.membershipTest(new StringKey("xyzzy")));      // False positive
    assertTrue(bf.membershipTest(new StringKey("abcd")));       // False positive
  }
  
  /** Test a DynamicBloomFilter */
  public void testDynamicBloomFilter() {
    Filter bf = new DynamicBloomFilter(8, 2, 2);
    Key key = new StringKey("toto");
    Key k2 = new StringKey("lulu");
    Key k3 = new StringKey("mama");
    bf.add(key);
    bf.add(k2);
    bf.add(k3);
    assertTrue(bf.membershipTest(key));
    assertFalse(bf.membershipTest(new StringKey("graknyl")));
    assertFalse(bf.membershipTest(new StringKey("xyzzy")));
    assertTrue(bf.membershipTest(new StringKey("abcd")));       // False positive
  }
}//end class
