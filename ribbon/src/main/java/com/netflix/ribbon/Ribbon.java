/*
 * Copyright 2014 Netflix, Inc.
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
package com.netflix.ribbon;

import com.netflix.ribbon.http.HttpResourceGroup;
import com.netflix.ribbon.proxy.RibbonDynamicProxy;

public final class Ribbon {

    private Ribbon() {
    }

    public static HttpResourceGroup createHttpResourceGroup(String name) {
        return new HttpResourceGroup(name);
    }

    public static HttpResourceGroup createHttpResourceGroup(String name, ClientOptions options) {
        return new HttpResourceGroup(name, options);
    }

    public static <T> T from(Class<T> contract) {
        return RibbonDynamicProxy.newInstance(contract, null);
    }

    public static <T> T from(Class<T> contract, HttpResourceGroup httpResourceGroup) {
        return RibbonDynamicProxy.newInstance(contract, httpResourceGroup);
    }
}