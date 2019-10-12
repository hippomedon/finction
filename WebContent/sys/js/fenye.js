//��ҳ
layui.use(['laypage', 'layer'], function() {
    var laypage = layui.laypage
        , layer = layui.layer;
    laypage.render({
        elem: 'demo11'
        , count: 1000
        , limit: 100
        , limits: [100, 300, 500]
        ,theme: '#000'
    });
});
/**
 * Created by Hippomedon on 2019/3/26.
 */
