package com.somegood;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C) 2012 by Scott Byrns
 * http://github.com/scottbyrns
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p/>
 * Created 4/26/12 2:35 AM
 */
public class JunitTestDocument
{

    // { "documentName": "Test Document", "mapList": [{"key":{"latitude":123,"longitude":321}}, {"name": {"latitude":123,"longitude":321}, "location": {"latitude":123,"longitude":321}} ] }

    private String docuemntName;
    private List<Map<String, GeoLocation>> mapList;

    public String getDocuemntName()
    {
        return docuemntName;
    }

    public void setDocuemntName(String docuemntName)
    {
        this.docuemntName = docuemntName;
    }

    public List<Map<String, GeoLocation>> getMapList()
    {
        return mapList;
    }

    public void setMapList(List<Map<String, GeoLocation>> mapList)
    {
        this.mapList = mapList;
    }
}
