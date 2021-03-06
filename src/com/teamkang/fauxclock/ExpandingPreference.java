/**
 * Copyright 2011 Roman Birg, Paul Reioux, RootzWiki

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.teamkang.fauxclock;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ExpandingPreference extends RelativeLayout {

    String TAG = "ExpandingPreference";

    protected Context mContext;
    protected boolean mIsExpanded;
    protected View mExpandedView;
    protected TextView mTitle;
    protected ImageView openStateImage;
    protected ImageView mIcon;
    protected OnClickListener mOnClickListener;

    // used when creating from XML
    public ExpandingPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        mIsExpanded = false;

        // LayoutInflater layoutInflater = (LayoutInflater) context
        // .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutInflater.from(context).inflate(R.layout.expanding_preference, this, true);

        // View view = layoutInflater.inflate(R.layout.expanding_preference,
        // this);
        openStateImage = (ImageView) findViewById(R.id.open_state);
        openStateImage.setImageResource(R.drawable.expander_ic_maximized);

        mIcon = (ImageView) findViewById(R.id.icon);
        mIcon.setVisibility(GONE);

        mTitle = (TextView) findViewById(R.id.title);

        /**
         * gpu scaling gov "ondemand" >
         * /sys/devices/platform/kgsl/msm_kgsl/kgsl-3d0/scaling_governor
         * "ondemand" or "performance"
         */

        /**
         * /sys/devices/platform/kgsl/msm_kgsl/kgsl-3d0/io_fraction default at
         * 33 (int) 40 also viable
         */

    }

    public void setExpanded(boolean expanded) {
        if (expanded) {
            openStateImage.setImageResource(R.drawable.expander_ic_minimized);
            // openStateImage.setVisibility(View.VISIBLE);

        } else {
            openStateImage.setImageResource(R.drawable.expander_ic_maximized);
            // openStateImage.setVisibility(View.GONE);

        }
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public void setExpandedView(View v) {
        Log.e(TAG, "Setting expanded view");
        // this.addView(v);
        mExpandedView = v;
    }
}
