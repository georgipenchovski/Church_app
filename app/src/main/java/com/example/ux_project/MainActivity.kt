package com.example.ux_project

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private val sceneList = mutableListOf<Scene>()
    private val sceneAdapter = SceneAdapter(sceneList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewScenes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = sceneAdapter
        sceneAdapter.context = this

        // Example scene list
        sceneList.addAll(
            listOf(
                Scene(
                    1,
                    "Свети Атанасий",
                    "„Свети Атанасий“ е късносредновековна българска църква в град Бобошево, област Кюстендил.\n" +
                            "\n" +
                            "\n" +
                            "Свети Атанасий – икона върху платно в патронната ниша на западната фасада.\n" +
                            "Църквата се намира върху обширна тераса в градските гробища, в т.нар. Горна махала на град Бобошево. Малка, еднокорабна църква с полукръгла апсида и с анти. Дълга е 8 м и широка 5 м. (външни размери). От лявата страна на апсидата се намира проскомидийната ниша, а вдясно – четвъртита, на диаконика. На северната страна има малка, полукръгла ниша – умивалня. Църквата е имала сводово покритие, което при реставрацията и е заменено със стреховидно. През XVIII век е прибавен закрит притвор, а през 1926-27 г. е изграден нов притвор с трапезария. Стените на първоначалната църква, дебели 0,70 м. са каменни. Църквата е била изписана изцяло отвътре, а западната фасада – и отвън, съобразно установения канон. Съгласно получетливия ктиторски надпис на южната стена църквата е построена през 1590 или 1600 г. До 29 октомври 1862 г. тя е главна църква на селото и в нея се черкуват бобошевци и хора от съседните села. След построяването на голямата църква „Света Богородица“, „Свети Атанасий“ е превърната в гробищна църква.",
                    "https://upload.wikimedia.org/wikipedia/commons/5/59/Church_of_Saint_Athanasius%2C_Boboshevo.2.jpg"
                ),
                Scene(
                    2,
                    "Бельова църква",
                    "A peaceful beach with a sunset.",
                    "https://upload.wikimedia.org/wikipedia/commons/8/80/Nikola-Obrazopisov-Belyova-church-1892.jpg"
                ),
                Scene(
                    3,
                    "Свети Георги",
                    "A beautiful view of the mountains.",
                    "https://upload.wikimedia.org/wikipedia/commons/b/b6/SvetiGeorgi.Kyustendil.1.jpg"
                ),
                Scene(
                    4,
                    "Свети Димитър",
                    "A beautiful view of the mountains.",
                    "https://upload.wikimedia.org/wikipedia/commons/7/7b/Church_pataleniza.jpg"
                )
            )
        )

        sceneAdapter.setOnItemClickListener { scene ->
            val intent = Intent(this, SceneDetailActivity::class.java)
            intent.putExtra("scene", scene) // Pass the scene data to the activity
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)  // Inflate the menu
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_icon -> {
                // Handle the icon click here
                Toast.makeText(this, "Search clicked!", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}
