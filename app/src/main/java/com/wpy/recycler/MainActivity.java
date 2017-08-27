package com.wpy.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wpy.recycler.adapter.RecyclerAdapter;
import com.wpy.recycler.adapter.SecondaryListAdapter;
import com.wpy.recycler.bean.City;
import com.wpy.recycler.bean.InfoDean;

import java.util.ArrayList;
import java.util.List;

/**
 * Recycler实现二级列表
 * http://blog.csdn.net/yuhys/article/details/70228591
 * http://wy521angel.blog.51cto.com/3262615/1572713
 */
public class MainActivity extends AppCompatActivity {
    private List<SecondaryListAdapter.DataTree<String, String>> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiView();
    }

    private void intiView() {
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //RecyclerView的尺寸在每次改变时   所以没有设置该代码会进行绘制浪费资源
        //requestLayout()是很昂贵的,因为他会要求重新布局，重新绘制（详细请看Android优化）
        // 所以如当不是瀑布流时，设置这个可以避免重复的增删造成而外的浪费资源
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new RvDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        RecyclerAdapter adapter = new RecyclerAdapter(this);
        adapter.setData(datas);
        recycler.setAdapter(adapter);
    }

    {

        List<InfoDean> group = new ArrayList<>();
        List<City> itemsList = new ArrayList<>();
        itemsList.add(new City("海淀区"));
        itemsList.add(new City("朝阳区"));
        itemsList.add(new City("大兴区"));
        group.add(new InfoDean("北京市", itemsList));

        List<City> itemsList1 = new ArrayList<>();
        itemsList1.add(new City("许昌市"));
        itemsList1.add(new City("周口市"));
        itemsList1.add(new City("新乡市"));
        group.add(new InfoDean("河南省", itemsList1));

        List<City> itemsList2 = new ArrayList<>();
        itemsList2.add(new City("邯郸市"));
        itemsList2.add(new City("保定市"));
        itemsList2.add(new City("石家庄"));
        group.add(new InfoDean("河北省", itemsList2));

        List<City> itemsList3 = new ArrayList<>();
        itemsList3.add(new City("邯郸市"));
        itemsList3.add(new City("保定市"));
        itemsList3.add(new City("石家庄"));
        group.add(new InfoDean("河北省", itemsList2));


        List<City> itemsList4 = new ArrayList<>();
        itemsList4.add(new City("邯郸市"));
        itemsList4.add(new City("保定市"));
        itemsList4.add(new City("石家庄"));
        group.add(new InfoDean("山东省", itemsList2));



        List<City> itemsList5 = new ArrayList<>();
        itemsList5.add(new City("邯郸市"));
        itemsList5.add(new City("保定市"));
        itemsList5.add(new City("石家庄"));
        group.add(new InfoDean("陕西省", itemsList2));
        for (int i = 0; i < group.size(); i++) {
            List<City> city = group.get(i).getCity();
            datas.add(new SecondaryListAdapter.DataTree<String,String>(group.get(i).getName(),
                    city));

        }

    }
}
