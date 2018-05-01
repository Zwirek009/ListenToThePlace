package pl.wiraszka.listentotheplace

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import pl.wiraszka.listentotheplace.fragments.AddMusicFragment
import pl.wiraszka.listentotheplace.fragments.MusicListFragment

class MainActivity : AppCompatActivity() {

    private val addMusicFragment: AddMusicFragment
    private val musicListFragment: MusicListFragment

    init {
        addMusicFragment = AddMusicFragment()
        musicListFragment = MusicListFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_add_music -> transaction.replace(R.id.fragment_container, addMusicFragment)
            R.id.navigation_music_list -> transaction.replace(R.id.fragment_container, musicListFragment)
        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, musicListFragment)
        transaction.commit()
    }
}
