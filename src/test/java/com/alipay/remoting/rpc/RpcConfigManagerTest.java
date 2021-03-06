/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.remoting.rpc;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RpcConfigManagerTest {
    @BeforeClass
    public static void initClass() {
    }

    @Before
    public void init() {
    }

    @After
    public void stop() {
    }

    @AfterClass
    public static void afterClass() {
    }

    @Test
    public void testSystemSettings() {
        Assert.assertTrue(RpcConfigManager.dispatch_msg_list_in_default_executor());

        Assert.assertFalse(RpcConfigManager.server_ssl_enable());
        Assert.assertFalse(RpcConfigManager.server_ssl_need_client_auth());
        Assert.assertNull(RpcConfigManager.server_ssl_keystore_pass());
        Assert.assertNull(RpcConfigManager.server_ssl_keystore());
        Assert.assertNull(RpcConfigManager.server_ssl_keystore_type());
        Assert.assertEquals(KeyManagerFactory.getDefaultAlgorithm(),
            RpcConfigManager.server_ssl_kmf_algorithm());

        Assert.assertFalse(RpcConfigManager.client_ssl_enable());
        Assert.assertNull(RpcConfigManager.client_ssl_keystore_pass());
        Assert.assertNull(RpcConfigManager.client_ssl_keystore());
        Assert.assertNull(RpcConfigManager.client_ssl_keystore_type());
        Assert.assertEquals(TrustManagerFactory.getDefaultAlgorithm(),
            RpcConfigManager.client_ssl_tmf_algorithm());
    }
}
