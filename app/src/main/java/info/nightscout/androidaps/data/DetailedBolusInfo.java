package info.nightscout.androidaps.data;

import android.content.Context;

import com.rits.cloning.Cloner;

import org.json.JSONObject;

import java.util.Date;

import info.nightscout.androidaps.db.CareportalEvent;
import info.nightscout.androidaps.db.Source;

/**
 * Created by mike on 29.05.2017.
 */

public class DetailedBolusInfo {
    public long date = System.currentTimeMillis();
    public String eventType = CareportalEvent.MEALBOLUS;
    public double insulin = 0;
    public double carbs = 0;
    public int source = Source.NONE;
    public boolean isValid = true;
    public double glucose = 0;             // Bg value in current units
    public String glucoseType = "";        // NS values: Manual, Finger, Sensor
    public int carbTime = 0;               // time shift of carbs in minutes
    public JSONObject boluscalc = null;    // additional bolus wizard info
    public Context context = null;         // context for progress dialog
    public long pumpId = 0;                // id of record if comming from pump history (not a newly created treatment)
    public boolean isSMB = false;          // is a Super-MicroBolus
    public long deliverAt = 0;             // SMB should be delivered within 1 min from this time

    public DetailedBolusInfo copy() {
        Cloner cloner = new Cloner();
        return cloner.deepClone(this);
    }

    @Override
    public String toString() {
        return new Date(date).toLocaleString() +
                " insulin: " + insulin +
                " carbs: " + carbs +
                " isValid: " + isValid +
                " carbTime: " + carbTime +
                " isSMB: " + isSMB +
                " deliverAt: " + new Date(deliverAt).toLocaleString();
    }
}
