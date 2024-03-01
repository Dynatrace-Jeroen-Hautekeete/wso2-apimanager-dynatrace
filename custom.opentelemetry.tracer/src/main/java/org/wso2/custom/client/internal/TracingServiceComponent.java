/*
 * Copyright (c) 2021 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.custom.client.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.wso2.carbon.apimgt.tracing.OpenTracer;
import org.wso2.custom.client.OpenTelemetryTracer;

/** TracingServiceComponent. */
@Component(
         name = "org.wso2.custom.client.TracingServiceComponent",
        immediate = true)
public class TracingServiceComponent {

    /** TracingServiceComponent Logger. */
    private static final Log LOG =
            LogFactory.getLog(TracingServiceComponent.class);

    /** TracingServiceComponent ServiceRgistration. */
    private ServiceRegistration registration;

    /** TracingServiceComponent activation.
     * @param componentContext component tracing context
     * */
    @Activate
    protected final void activate(final ComponentContext componentContext) {
        LOG.warn("OpenTelemetryTracer activated");
        try {
            BundleContext bundleContext = componentContext.getBundleContext();
            registration = bundleContext.registerService(OpenTracer.class,
                    new OpenTelemetryTracer(), null);

        } catch (Exception e) {
            LOG.error("Error occured in tracing component activation", e);
        }
    }

    /** TracingServiceComponent deactivation.
     * @param componentContext component tracing context
     * */
    @Deactivate
    protected final void deactivate(final ComponentContext componentContext) {

        LOG.warn("OpenTelemetryTracer deactivated");
        registration.unregister();
    }
}

