/*
 * Copyright 2024 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.netflix.maestro.models.definition;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.netflix.maestro.MaestroBaseTest;
import org.junit.Test;

public class GitInfoTest extends MaestroBaseTest {

  @Test
  public void testRoundTripSerde() throws Exception {
    GitInfo wfd =
        loadObject("fixtures/workflows/definition/sample-valid-git-info.json", GitInfo.class);
    assertEquals(wfd, MAPPER.readValue(MAPPER.writeValueAsString(wfd), GitInfo.class));
  }

  @Test(expected = UnrecognizedPropertyException.class)
  public void testInvalidGitInfoDefinition() throws Exception {
    loadObject("fixtures/workflows/definition/sample-invalid-git-info.json", GitInfo.class);
  }
}
