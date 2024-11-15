package pccoe.student.laundrymart

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation
import pccoe.student.laundrymart.databinding.ActivityMainBinding
import pccoe.student.laundrymart.ui_home.Offers_fragment
import pccoe.student.laundrymart.ui_home.Orders_fragment
import pccoe.student.laundrymart.ui_home.Profile_fragment
import pccoe.student.laundrymart.ui_home.home_fragment
import pccoe.student.laundrymart.ui_home.Schedule_pickup_fragment

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Home",R.drawable.home_vector)
        )
        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Schedule Pickup",R.drawable.ic_schedule_pickup)
        )
        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"Orders",R.drawable.ic_orders)
        )
        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(4,"Offers",R.drawable.ic_offers)
        )
        binding.bottomNavigation.add(
            CurvedBottomNavigation.Model(5,"Profile",R.drawable.ic_profile)
        )


        binding.bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1->{ replacefragment(home_fragment())}
                2->{replacefragment(Schedule_pickup_fragment())}
                3->{replacefragment(Orders_fragment())}
                4->{replacefragment(Offers_fragment())}
                5->{replacefragment(Profile_fragment())}
            }
        }
replacefragment(home_fragment())
        binding.bottomNavigation.show(1)
    }
    private fun replacefragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout,fragment)
            .commit()
    }
}