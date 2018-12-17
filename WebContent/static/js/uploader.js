jQuery(function () {
    var $ = jQuery,
        $list = $('#fileList'),
        // 优化retina, 在retina下这个值是2
        ratio = window.devicePixelRatio || 1,
        // 缩略图大小
        thumbnailWidth = 100 * ratio,
        thumbnailHeight = 100 * ratio,
        // Web Uploader实例
        uploader;
    // 初始化Web Uploader
    uploader = WebUploader.create({
        // 自动上传。
        auto: false,
        // swf文件路径
        swf: 'js/Uploader.swf',
        // 文件接收服务端。
        server: 'uploader.action',
        threads: '5',        //同时运行5个线程传输
        fileNumLimit: '10',  //文件总数量只能选择10个 

        // 选择文件的按钮。可选。
        pick: {
            id: '#filePicker',  //选择文件的按钮
            multiple: true
        },   //允许可以同时选择多个图片
        // 图片质量，只有type为`image/jpeg`的时候才有效。
        quality: 90,

        //限制传输文件类型，accept可以不写 
        accept: {
            title: 'Images',//描述
            extensions: 'gif,jpg,jpeg,bmp,png,zip',//类型
            mimeTypes: 'image/*'//mime类型
        }
    });

    function remove(file) {
        console.log(file);
    }

    // 当有文件添加进来的时候，创建img显示缩略图使用
    uploader.on('fileQueued', function (file) {
        var $li = $(
                '<div id="' + file.id + '" class="file-item thumbnail" ' +
                'style="float:left;margin-right:10px;">' +
                '<img>' +
                '<div class="info">' + file.name + '</div>' +
                '<a onclick="remove( \'' + file.id + '\')">删除</a>' +
                '</div>'
            ),
            $img = $li.find('img');

        // $list为容器jQuery实例
        $list.append($li);

        // 创建缩略图
        // 如果为非图片文件，可以不用调用此方法。
        // thumbnailWidth x thumbnailHeight 为 100 x 100
        uploader.makeThumb(file, function (error, src) {
            if (error) {
                $img.replaceWith('<span>不能预览</span>');
                return;
            }

            $img.attr('src', src);
        }, thumbnailWidth, thumbnailHeight);
    });

    // 文件上传过程中创建进度条实时显示。    uploadProgress事件：上传过程中触发，携带上传进度。 file文件对象 percentage传输进度 Nuber类型
    uploader.on('uploadProgress', function (file, percentage) {
        var $li = $('#' + file.id),
            $percent = $li.find('.progress span');

        // 避免重复创建
        if (!$percent.length) {
            $percent = $('<p class="progress"><span>124</span></p>')
                .appendTo($li)
                .find('span');
        }

        $percent.css('width', percentage * 100 + '%');
    });

    // 文件上传成功时候触发，给item添加成功class, 用样式标记上传成功。 file：文件对象，    response：服务器返回数据
    uploader.on('uploadSuccess', function (file, response) {
        $('#' + file.id).addClass('upload-state-done');
        //console.info(response);
        $("#upInfo").html("<font color='red'>" + response._raw + "</font>");
    });

    // 文件上传失败                                file:文件对象 ， code：出错代码
    uploader.on('uploadError', function (file, code) {
        var $li = $('#' + file.id),
            $error = $li.find('div.error');

        // 避免重复创建
        if (!$error.length) {
            $error = $('<div class="error"></div>').appendTo($li);
        }

        $error.text('上传失败!');
    });

    // 不管成功或者失败，文件上传完成时触发。 file： 文件对象
    uploader.on('uploadComplete', function (file) {
        $('#' + file.id).find('.progress').remove();
    });

    //绑定提交事件
    $("#btn").click(function () {
        uploader.upload();   //执行手动提交
        alert("上传成功");
    });


    $("#qk").click(function () {
        closeUploader();
    });


    function closeUploader() {
        // 移除所有缩略图并将上传文件移出上传序列
        for (var i = 0; i < uploader.getFiles().length; i++) {
            // 将图片从上传序列移除
            uploader.removeFile(uploader.getFiles()[i]);
            //uploader.removeFile(uploader.getFiles()[i], true);
            //delete uploader.getFiles()[i];
            // 将图片从缩略图容器移除
            var $li = $('#' + uploader.getFiles()[i].id);
            $li.off().remove();
        }

        setState('pedding');

        // 重置文件总个数和总大小
        fileCount = 0;
        fileSize = 0;
        // 重置uploader，目前只重置了文件队列
        uploader.reset();
        // 更新状态等，重新计算文件总个数和总大小
        updateStatus();
    }

});