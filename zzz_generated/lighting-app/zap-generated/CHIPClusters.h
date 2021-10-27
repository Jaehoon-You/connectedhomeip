/*
 *
 *    Copyright (c) 2021 Project CHIP Authors
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

// THIS FILE IS GENERATED BY ZAP

// Prevent multiple inclusion
#pragma once

#include <app-common/zap-generated/ids/Clusters.h>
#include <app-common/zap-generated/ids/Commands.h>

#include <controller/CHIPCluster.h>
#include <lib/core/CHIPCallback.h>
#include <lib/support/Span.h>

namespace chip {
namespace Controller {

class DLL_EXPORT OnOffCluster : public ClusterBase
{
public:
    OnOffCluster() : ClusterBase(app::Clusters::OnOff::Id) {}
    ~OnOffCluster() {}

    // Cluster Commands
    CHIP_ERROR Off(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR On(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR Toggle(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);

    // Cluster Attributes
    CHIP_ERROR ReadAttributeOnOff(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR ReadAttributeGlobalSceneControl(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR ReadAttributeOnTime(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR ReadAttributeOffWaitTime(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR ReadAttributeStartUpOnOff(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR ReadAttributeFeatureMap(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR ReadAttributeClusterRevision(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback);
    CHIP_ERROR WriteAttributeOnTime(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback,
                                    uint16_t value);
    CHIP_ERROR WriteAttributeOffWaitTime(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback,
                                         uint16_t value);
    CHIP_ERROR WriteAttributeStartUpOnOff(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback,
                                          uint8_t value);
    CHIP_ERROR SubscribeAttributeOnOff(Callback::Cancelable * onSuccessCallback, Callback::Cancelable * onFailureCallback,
                                       uint16_t minInterval, uint16_t maxInterval);
    CHIP_ERROR ReportAttributeOnOff(Callback::Cancelable * onReportCallback);

private:
};

} // namespace Controller
} // namespace chip
