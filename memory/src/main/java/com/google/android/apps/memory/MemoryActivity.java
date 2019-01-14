/*
 * Copyright 2019. Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.apps.memory;

import android.os.Bundle;
import com.google.android.apps.playgames.common.PlayGamesActivity;
import com.google.android.apps.santatracker.util.MeasurementManager;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MemoryActivity extends PlayGamesActivity {

    private MemoryMatchFragment mMemoryMatchFragment;
    private FirebaseAnalytics mMeasurement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMemoryMatchFragment = MemoryMatchFragment.newInstance();
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(
                        com.google.android.apps.playgames.R.id.mainFragmentContainer,
                        mMemoryMatchFragment)
                .commit();

        // App Measurement
        mMeasurement = FirebaseAnalytics.getInstance(this);
        MeasurementManager.recordScreenView(
                mMeasurement,
                getString(
                        com.google
                                .android
                                .apps
                                .santatracker
                                .common
                                .R
                                .string
                                .analytics_screen_memory));
    }

    @Override
    public void onBackPressed() {
        if (mMemoryMatchFragment != null) {
            mMemoryMatchFragment.onBackKeyPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_memory;
    }

    @Override
    public void onSignInSucceeded() {
        super.onSignInSucceeded();
        mMemoryMatchFragment.onSignInSucceeded();
    }

    @Override
    public String getGameId() {
        return getResources().getString(com.google.android.apps.playgames.R.string.memory_game_id);
    }

    @Override
    public String getGameTitle() {
        return getString(com.google.android.apps.santatracker.common.R.string.memory);
    }

    @Override
    public void onSignInFailed() {
        super.onSignInFailed();
        mMemoryMatchFragment.onSignInFailed();
    }
}
