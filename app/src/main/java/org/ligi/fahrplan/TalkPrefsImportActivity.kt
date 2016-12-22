package org.ligi.fahrplan

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class TalkPrefsImportActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val lecturesForAllDays = FahrplanMisc.loadLecturesForAllDays(this)

        if (lecturesForAllDays == null) {
            android.support.v7.app.AlertDialog.Builder(this).setMessage("Cannot load lectures")
                    .setPositiveButton(android.R.string.ok, { dialogInterface: DialogInterface, i: Int ->
                        finish()
                    })
                    .show()
        } else {

            val stringArrayExtra = intent.getStringExtra("CSV")

            var i=0
            stringArrayExtra.toString().split(",").forEach {
                lecturesForAllDays.getLecture(it)?.let {
                    it.highlight = true
                    FahrplanMisc.writeHighlight(this, it)
                    i++
                }
            }

            android.support.v7.app.AlertDialog.Builder(this).setMessage("Imported $i favorites")
                    .setPositiveButton(android.R.string.ok,{ dialogInterface: DialogInterface, i: Int ->
                        startActivity(Intent(this,StarredListActivity::class.java))
                        finish()
                    })
                    .show()
        }
    }
}
