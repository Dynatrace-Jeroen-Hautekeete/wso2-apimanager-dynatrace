/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
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
package org.wso2.custom.client;

import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.apimgt.tracing.OpenTracer;

/**
 * Class for getting OpenTelemetry tracer from reading configuration file.
 * */
public class OpenTelemetryTracer implements OpenTracer {
    /** OpenTracer name. */
    private static final String NAME = "opentelemetry";
    /** OpenTracer log. */
    private static final Log LOG = LogFactory.
            getLog(OpenTelemetryTracer.class);

    /** OpenTracer trace accessor.
     * @param serviceName name of the service to be traced
     */
    @Override
    public final Tracer getTracer(final String serviceName) {

        return GlobalTracer.get();
    }

    /** OpenTracer name accessor. */
    @Override
    public final String getName() {
        LOG.warn("getName() called");
        return NAME;
    }
}
