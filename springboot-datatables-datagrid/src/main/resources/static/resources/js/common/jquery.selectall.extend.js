(function($) {
	// 点击选择所有按钮后执行的操作
	$.fn.selectAll = function(oSelect) {
		// 全选之前初始化需要存储的数据  
		var chks = $("[name=" + oSelect.selectCheckbox + "]:checkbox");
		oSelect.selectedDatas = {};
		for (var i in chks[0].attributes) {
			oSelect.selectedDatas[chks[0].attributes[i].name + "s"] = "";
		}
		if (!oSelect.isAllSelected) {
			oSelect.isAllSelected = true;          
			$("#" + oSelect.tableName + "_filter label a[onclick=\"selectAllObject.selectAll()\"]").addClass("dt-button-search");          
			// 根据当前的筛选参数将需要选择的数据从后台全部获取      
			$.ajax({
				type: 'post',
				dataType: 'json',
				url: oSelect.baseDir + oSelect.url + "?t=" + new Date(),
				data: {
					aoData: oSelect.allSelectParam
				},
				success: function(data) {
					var str = data;
					if (isNullOrEmpty(str)) {
						//do nothing
					} else {
						for (var i in str) {
							oSelect.selectedDatas[i] = str[i];
						}
						$("#" + oSelect.allSelectCheckbox).prop("checked", true);
						// 将表格所有checkbox改为勾选状态
						$("#" + oSelect.tableName).find("tbody").find("tr").each(
							function(index, element) {
								$(element).find("td:first").find("input").prop("checked", "true");
							});
					}
				}
			});
		} else {
			oSelect.isAllSelected = false;
			$("#" + oSelect.allSelectCheckbox).removeProp("checked");
			$("#" + oSelect.tableName + "_filter label a[onclick=\"selectAllObject.selectAll()\"]").removeClass("dt-button-search");
			$("#" + oSelect.tableName).find("tbody").find("tr").each(
				function(index, element) {
					$(element).find("td:first").find("input").removeProp("checked");
				});
		}
	};
	// 点击表格的全选checkbox的操作
	$.fn.allSelectCheckboxClick = function(oSelect) {
		var chks = $("[name=" + oSelect.selectCheckbox + "]:checkbox");
		var selectedChks = 0;
		var ids = oSelect.selectedDatas.ids;
		if ($("#" + oSelect.allSelectCheckbox).prop("checked")) {
			$("[name=" + oSelect.selectCheckbox + "]:checkbox").prop("checked", true);
			for (var i = 0; i < chks.length; i++) {
				var id = chks[i].value;
				if (!$.fn._isSelected_(ids, id)) {
					for (var x in chks[i].attributes) {
						oSelect.selectedDatas[chks[i].attributes[x].name + "s"] += chks[i].attributes[x].value + ",";
						oSelect.selectedDatas[chks[i].attributes[x].name + "s"] = oSelect.selectedDatas[chks[i].attributes[x].name + "s"].replace("undefined", '');
					}
				}
			}
		} else {
			$("[name=" + oSelect.selectCheckbox + "]:checkbox").removeProp("checked");
			for (var i = 0; i < chks.length; i++) {
				for (var x in chks[i].attributes) {
					oSelect.selectedDatas[chks[i].attributes[x].name + "s"]  = oSelect.selectedDatas[chks[i].attributes[x].name + "s"].replace(chks[i].attributes[x].value + ",", '');
					oSelect.selectedDatas[chks[i].attributes[x].name + "s"] = oSelect.selectedDatas[chks[i].attributes[x].name + "s"].replace("undefined", '');
				}
			}
		}
	};
	// 点击表格的单选checkbox的操作 
	$.fn.selectCheckboxClick = function(element, oSelect) {
		var chks = $("[name=" + oSelect.selectCheckbox + "]:checkbox");
		var selectedChks = 0;
		var tempid = $(element).prop("value");
		if ($(element).prop("checked") != true) {
			for (var x in element.attributes) {
				oSelect.selectedDatas[element.attributes[x].name + "s"] = oSelect.selectedDatas[element.attributes[x].name + "s"].replace(element.attributes[x].value + ",", '');
				oSelect.selectedDatas[element.attributes[x].name + "s"]  = oSelect.selectedDatas[element.attributes[x].name + "s"].replace("undefined", '');
			}
		} else {
			for (var x in element.attributes) {
				oSelect.selectedDatas[element.attributes[x].name + "s"] += element.attributes[x].value + ",";
				oSelect.selectedDatas[element.attributes[x].name + "s"]  = oSelect.selectedDatas[element.attributes[x].name + "s"].replace("undefined", '');
			}
		}
		//循环遍历当前页数据统计被勾选数  
		for (var i = 0; i < chks.length; i++) {
			if (chks[i].checked == false) {
				$("#" + oSelect.allSelectCheckbox).prop("checked", false);
				break;
			}
			selectedChks++;
		}
		//根据勾选数与所有当前页总数比较断定表格的全选是否要勾选  
		if (chks.length == selectedChks) {
			$("#" + oSelect.allSelectCheckbox).prop("checked", true);
		}
	};
	// 改变页码后执行的操作
	$.fn.tableChangePage = function(oSelect) {
		var chks = $("[name=" + oSelect.selectCheckbox + "]:checkbox");
		var selectedChks = 0;
		if (oSelect.isAllSelected) {
			$("#" + oSelect.tableName + "_filter label a[onclick=\"selectAllObject.selectAll()\"]").addClass("dt-button-search");
		} else {
			$("#" + oSelect.tableName + "_filter label a[onclick=\"selectAllObject.selectAll()\"]").removeClass("dt-button-search");
		}
		$("#" + oSelect.tableName).find("tbody").find("tr").each(
			function(index, element) {
				var ids = oSelect.selectedDatas.ids;
				var id = $(element).find("td:first").find("input").val();
				if ($.fn._isSelected_(ids, id)) {
					$(element).find("td:first").find("input").prop("checked", true);
					selectedChks++;
				} else  {
					$(element).find("td:first").find("input").removeProp("checked");
				}  
			});
		if (0 != chks.length && chks.length == selectedChks) {
			$("#" + oSelect.allSelectCheckbox).prop("checked", true);  
		} else {
			$("#" + oSelect.allSelectCheckbox).removeProp("checked");
		}
	};
	// 判断是否记录的id是否存在已选的数据中 
	$.fn._isSelected_ = function(ids, id) {
		var idIndex = ids.indexOf(id);
		if (idIndex > -1) {
			return true;
		}  
		else {   
			return false;
		}
	};
})(jQuery);