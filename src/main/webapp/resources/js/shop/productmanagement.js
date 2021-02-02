$(function() {
	var listUrl = '/online-store/shopadmin/getproductlistbyshop?pageIndex=1&pageSize=999';
	var statusUrl = '/online-store/shopadmin/modifyproduct';
	getList();
	function getList() {
		$.getJSON(listUrl, function(data) {
			if (data.success) {
				var productList = data.productList;
				var tempHtml = '';
				productList.map(function(item, index) {
					var textOp = "Disable";
					var contraryStatus = 0;
					if (item.enableStatus == 0) {
						textOp = "Enable";
						contraryStatus = 1;
					} else {
						contraryStatus = 0;
					}

					tempHtml += '' + '<div class="row row-product">'
						+ '<div class="col-33">'
						+ item.productName
						+ '</div>'
						+ '<div class="col-20">'
						+ item.point
						+ '</div>'
						+ '<div class="col-40">'
						+ '<a href="#" class="edit" data-id="'
						+ item.productId
						+ '" data-status="'
						+ item.enableStatus
						+ '">Edit</a>'
						+ '<a href="#" class="status" data-id="'
						+ item.productId
						+ '" data-status="'
						+ contraryStatus
						+ '">'
						+ textOp
						+ '</a>'
						+ '<a href="#" class="preview" data-id="'
						+ item.productId
						+ '" data-status="'
						+ item.enableStatus
						+ '">Preview</a>'
						+ '</div>'
						+ '</div>';
				});
				$('.product-wrap').html(tempHtml);
			}
		});
	}

	$('.product-wrap')
		.on(
			'click',
			'a',
			function(e) {
				var target = $(e.currentTarget);
				if (target.hasClass('edit')) {
					window.location.href = '/online-store/shopadmin/productoperation?productId='
						+ e.currentTarget.dataset.id;
				} else if (target.hasClass('status')) {

					changeItemStatus(e.currentTarget.dataset.id,
						e.currentTarget.dataset.status);
				} else if (target.hasClass('preview')) {

					window.location.href = '/online-store/frontend/productdetail?productId='
						+ e.currentTarget.dataset.id;
				}
			});
	function changeItemStatus(id, enableStatus) {
		var product = {};
		product.productId = id;
		product.enableStatus = enableStatus;
		$.confirm('Are you sure?', function() {
			$.ajax({
				url: statusUrl,
				type: 'POST',
				data: {
					productStr: JSON.stringify(product),
					statusChange: true
				},
				dataType: 'json',
				success: function(data) {
					if (data.success) {
						$.toast('Success！');
						getList();
					} else {
						$.toast('Fail！');
					}
				}
			});
		});
	}
});