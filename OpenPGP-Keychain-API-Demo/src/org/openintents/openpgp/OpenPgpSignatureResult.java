/*
 * Copyright (C) 2013 Dominik Schürmann <dominik@dominikschuermann.de>
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

package org.openintents.openpgp;

import android.os.Parcel;
import android.os.Parcelable;

public class OpenPgpSignatureResult implements Parcelable {
    String signatureUserId;

    boolean signature;
    boolean signatureSuccess;
    boolean signatureUnknown;

    public OpenPgpSignatureResult() {

    }

    public OpenPgpSignatureResult(String signatureUserId, boolean signature,
            boolean signatureSuccess, boolean signatureUnknown) {
        this.signatureUserId = signatureUserId;

        this.signature = signature;
        this.signatureSuccess = signatureSuccess;
        this.signatureUnknown = signatureUnknown;
    }

    public OpenPgpSignatureResult(OpenPgpSignatureResult b) {
        this.signatureUserId = b.signatureUserId;

        this.signature = b.signature;
        this.signatureSuccess = b.signatureSuccess;
        this.signatureUnknown = b.signatureUnknown;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(signatureUserId);

        dest.writeByte((byte) (signature ? 1 : 0));
        dest.writeByte((byte) (signatureSuccess ? 1 : 0));
        dest.writeByte((byte) (signatureUnknown ? 1 : 0));
    }

    public static final Creator<OpenPgpSignatureResult> CREATOR = new Creator<OpenPgpSignatureResult>() {
        public OpenPgpSignatureResult createFromParcel(final Parcel source) {
            OpenPgpSignatureResult vr = new OpenPgpSignatureResult();
            vr.signatureUserId = source.readString();
            vr.signature = source.readByte() == 1;
            vr.signatureSuccess = source.readByte() == 1;
            vr.signatureUnknown = source.readByte() == 1;
            return vr;
        }

        public OpenPgpSignatureResult[] newArray(final int size) {
            return new OpenPgpSignatureResult[size];
        }
    };

    @Override
    public String toString() {
        String out = new String();
        out += "signature: " + signature;
        out += "\nsignatureSuccess: " + signatureSuccess;
        out += "\nsignatureUnknown: " + signatureUnknown;
        return out;
    }

}
