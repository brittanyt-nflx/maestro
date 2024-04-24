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
package com.netflix.maestro.models.stepruntime;

import static org.junit.Assert.assertEquals;

import com.netflix.maestro.MaestroBaseTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class StepBreakpointTest extends MaestroBaseTest {
  @BeforeClass
  public static void init() {
    MaestroBaseTest.init();
  }

  @Test
  public void testRoundTripSerde() throws Exception {
    StepBreakpoint expected =
        loadObject("fixtures/stepruntime/step_breakpoint.json", StepBreakpoint.class);
    String ser1 = MAPPER.writeValueAsString(expected);
    StepBreakpoint actual = MAPPER.readValue(ser1, StepBreakpoint.class);
    String ser2 = MAPPER.writeValueAsString(actual);
    assertEquals(expected, actual);
    assertEquals(ser1, ser2);
  }

  @Test
  public void testRoundTripSerdeNull() throws Exception {
    StepBreakpoint expected =
        loadObject("fixtures/stepruntime/step_breakpoint_null.json", StepBreakpoint.class);
    String ser1 = MAPPER.writeValueAsString(expected);
    StepBreakpoint actual = MAPPER.readValue(ser1, StepBreakpoint.class);
    String ser2 = MAPPER.writeValueAsString(actual);
    assertEquals(expected, actual);
    assertEquals(ser1, ser2);
  }
}
