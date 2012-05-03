package com.somegood;

import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.InvalidJSONStringException;
import com.scottbyrns.utilities.JSONObjectMapper;
import org.junit.Test;


import static junit.framework.Assert.fail;

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
 * Created 4/26/12 1:55 AM
 */
public class TestCoreDocuments
{
    @Test
    public void storeJSONDocument () {
        JunitTestDocument junitTestDocument = null;
        try {
            junitTestDocument = JSONObjectMapper.mapJSONStringToEntity("{ \"documentName\": \"Test Document\", \"mapList\": [{\"key\":{\"latitude\":123,\"longitude\":321}}, {\"name\": {\"latitude\":123,\"longitude\":321}, \"location\": {\"latitude\":123,\"longitude\":321}} ] }", JunitTestDocument.class);
        }
        catch (InvalidJSONStringException e) {
            e.printStackTrace();
            fail("The object mapper incorrectly reported the sample JSON to be invalid.");
        }
        catch (FatalMappingException e) {
            e.printStackTrace();
            fail("The JSON could not be mapped to the entity.");
        }
        new CoreDocuments().as("junit-test-document").store(junitTestDocument);

//        assertTrue(
//                "",
//
//                  )
    }
}
