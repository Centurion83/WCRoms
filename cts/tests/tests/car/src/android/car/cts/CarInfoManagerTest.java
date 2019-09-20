/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package android.car.cts;

import static org.junit.Assert.assertNotNull;

import android.car.Car;
import android.car.CarInfoManager;
import android.os.Bundle;
import android.platform.test.annotations.RequiresDevice;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@SmallTest
@RequiresDevice
@RunWith(AndroidJUnit4.class)
public class CarInfoManagerTest extends CarApiTestBase {

    private CarInfoManager mCarInfoManager;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mCarInfoManager = (CarInfoManager) getCar().getCarManager(Car.INFO_SERVICE);
    }

    @Test
    public void testVehicleId() throws Exception {
        assertNotNull(mCarInfoManager.getVehicleId());
    }

    @Test
    public void testNullables() throws Exception {
        // no guarantee of existence. just call and check if it throws exception.
        mCarInfoManager.getManufacturer();
        mCarInfoManager.getModel();
        mCarInfoManager.getModelYear();
    }
}
