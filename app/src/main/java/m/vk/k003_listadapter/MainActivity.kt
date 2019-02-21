package m.vk.k003_listadapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import m.vk.k003_listadapter.adapter.ContentAdapter
import m.vk.k003_listadapter.model.PostGenerator

class MainActivity : AppCompatActivity() {
    /*
    * ขอบคุณ www.akexorcist.com
    * https://www.akexorcist.com/2018/04/build-recycler-view-with-list-adapter-in-support-library.html
    * */
    private lateinit var adapter: ContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ContentAdapter()
        adapter.submitList(PostGenerator.get())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnRefresh.setOnClickListener {
            adapter.submitList(PostGenerator.get())
        }
    }
}
