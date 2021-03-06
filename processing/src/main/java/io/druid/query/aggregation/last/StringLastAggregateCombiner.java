/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
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

package io.druid.query.aggregation.last;

import io.druid.query.aggregation.ObjectAggregateCombiner;
import io.druid.segment.ColumnValueSelector;

import javax.annotation.Nullable;

public class StringLastAggregateCombiner extends ObjectAggregateCombiner<String>
{
  private String lastString;

  @Override
  public void reset(ColumnValueSelector selector)
  {
    lastString = (String) selector.getObject();
  }

  @Override
  public void fold(ColumnValueSelector selector)
  {
    lastString = (String) selector.getObject();
  }

  @Nullable
  @Override
  public String getObject()
  {
    return lastString;
  }

  @Override
  public Class<String> classOfObject()
  {
    return String.class;
  }
}
