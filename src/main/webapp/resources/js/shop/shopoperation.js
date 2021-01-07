/**
 * 1. get shop_category and area from DB
 * 2. call controller and register a shop when submitted
 */
$(function() {
	var initUrl = '/online-store/shopadmin/getshopinitinfo';
	var registerShopUrl = '/online-store/shopadmin/registershop';
	
	getShopInitInfo();
	alert('js triggered')
	// 1. get shop_category and area from DB
	function getShopInitInfo() {
		$.getJSON(initUrl, function(data) {
			if (data.success) {
				var tempShopCategoryHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item, index) {
					tempShopCategoryHtml += '<option data-id="' + item.shopCategoryId
							+ '">' + item.shopCategoryName + '</option>';
				});
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#shop-category').html(tempShopCategoryHtml);
				$('#area').html(tempAreaHtml);
			}
		});
	}
	
	// 2. call controller and register a shop when submitted
	$('#submit').click(function() {
		var shop = {};
		shop.shopName = $('#shop-name').val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();

		shop.shopCategory = {
			shopCategoryId : $('#shop-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
	
		shop.area = {
			areaId : $('#area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
	
		//image file
		var shopImg = $('#shop-img')[0].files[0];
		var formData = new FormData();
		formData.append('shopImg', shopImg);
		formData.append('shopStr', JSON.stringify(shop));
		
		var verifyCodeActual = $('#j_captcha').val();
		if (!verifyCodeActual) {
			$.toast('请输入验证码！');
			return;
		}
		formData.append('verifyCodeActual', verifyCodeActual);
		
		// call backend controller
		$.ajax({
			url : registerShopUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('Success！');
				} else {
					$.toast('Fail！' + data.errMsg);
				}
		
				$('#captcha_img').click();
			}
		});
	});
})