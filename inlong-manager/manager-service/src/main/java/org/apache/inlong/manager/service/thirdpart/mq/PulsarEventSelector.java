/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.inlong.manager.service.thirdpart.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.inlong.manager.common.enums.BizConstant;
import org.apache.inlong.manager.common.event.EventSelector;
import org.apache.inlong.manager.common.model.WorkflowContext;
import org.apache.inlong.manager.common.model.definition.ProcessForm;
import org.apache.inlong.manager.service.workflow.business.BusinessResourceWorkflowForm;

@Slf4j
public class PulsarEventSelector implements EventSelector {

    @Override
    public boolean accept(WorkflowContext context) {
        ProcessForm processForm = context.getProcessForm();
        if (processForm == null || !(processForm instanceof BusinessResourceWorkflowForm)) {
            return false;
        }
        BusinessResourceWorkflowForm form = (BusinessResourceWorkflowForm) processForm;
        String middlewareType = form.getBusinessInfo().getMiddlewareType();
        if (BizConstant.MIDDLEWARE_PULSAR.equalsIgnoreCase(middlewareType)) {
            return true;
        }
        log.warn("no need to create pulsar subscription group for groupId={}, as the middlewareType={}",
                form.getInlongGroupId(), middlewareType);
        return false;
    }
}