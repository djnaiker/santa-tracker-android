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

package com.google.android.apps.santatracker.customviews;

public abstract class ImageWithAlphaAndSize {

    public static int OPAQUE = 255;
    public static int INVISIBLE = 0;
    public static int ANIM_DURATION = 750;

    protected int mAlpha = OPAQUE;
    protected float mSize = 1.0f;

    public boolean getIsInvisible() {
        return mAlpha == INVISIBLE;
    }

    public int getAlpha() {
        return mAlpha;
    }

    public void setAlpha(int alpha) {
        this.mAlpha = alpha;
    }

    public float getSize() {
        return mSize;
    }

    public void setSize(float size) {
        this.mSize = size;
    }
}
