package com.somegood;
import com.scottbyrns.utilities.FatalMappingException;
import com.scottbyrns.utilities.JSONObjectMapper;
import redis.clients.jedis.Jedis;

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
 * Created 4/26/12 2:49 AM
 */
public class CoreDocuments
{
    private String key, store;
    private Class entity;

    public CoreDocuments as(String key)
    {
        this.key = key;
        if (null != store) {
             doStore();
        }
        return this;
    }

    public CoreDocuments store(Object entity)
    {
        try
        {
            store = JSONObjectMapper.convertEntityToJSON(entity);
        }
        catch (FatalMappingException e)
        {
            store = "";
        }

        if (null != key) {
            doStore();
        }

        return this;
    }

    private void doStore () {
        Jedis jedis = new Jedis("localhost");
        jedis.connect();
        jedis.set(key,
                  store);
        jedis.bgsave();
    }

    public CoreDocuments as (Class entity) {
        this.entity = entity;
        return this;
    }

    public <T> T open (String key) {
        this.key = key;

        Jedis jedis = new Jedis("localhost");
        jedis.connect();
        String value = jedis.get(key);
        try {
            return JSONObjectMapper.mapJSONStringToEntity(key, (Class<T>)entity);
        }
        catch (Exception e) {

        }
        return (T)entity;
    }
}
