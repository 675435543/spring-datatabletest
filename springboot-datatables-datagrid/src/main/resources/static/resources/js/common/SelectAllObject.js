function SelectAllObject(oSelect) {
	// 设置请求数据的基础路径 
	this.baseDir = oSelect.sBaseDir;
	// 设置请求数据的接口路径 
	this.url = oSelect.sUrl;
	// 当前操作的表格 
	this.tableName = oSelect.sTableName;
	// 当前操作的表格全选checkbox的name值 
	this.allSelectCheckbox = oSelect.sAllSelectCheckbox;
	// 当前操作的表格单选checkbox的name值 
	this.selectCheckbox = oSelect.sSelectCheckbox;
	// 当前表格的查询搜索参数 
	this.allSelectParam = oSelect.oAllSelectParam;
	// 当前表格是否已被选择所有 
	this.isAllSelected = oSelect.bIsAllSelected;
	// 存储已被选中的记录的关键信息 
	this.selectedDatas = oSelect.oSelectedDatas;
}

SelectAllObject.prototype.setBaseDir = function(baseDir) {
	this.baseDir = baseDir;
}
SelectAllObject.prototype.setUrl = function(url) {
	this.url = url;
}
SelectAllObject.prototype.setTableName = function(tableName) {
	this.tableName = tableName;
}
SelectAllObject.prototype.setAllSelectCheckbox = function(allSelectCheckbox) {
	this.allSelectCheckbox = allSelectCheckbox;
}
SelectAllObject.prototype.setSelectCheckbox = function(selectCheckbox) {
	this.selectCheckbox = selectCheckbox;
}
SelectAllObject.prototype.setAllSelectParam = function(allSelectParam) {
	this.allSelectParam = allSelectParam;
}
SelectAllObject.prototype.setIsAllSelected = function(isAllSelected) {
	this.isAllSelected = isAllSelected;
}
SelectAllObject.prototype.setSelectedDatas = function(selectedDatas) {
	this.selectedDatas = selectedDatas;
}
SelectAllObject.prototype.selectAll = function() {
	$(this).selectAll(this);
}
SelectAllObject.prototype.allSelectCheckboxClick = function() {
	$(this).allSelectCheckboxClick(this);
}
SelectAllObject.prototype.selectCheckboxClick = function(element) {
	$(this).selectCheckboxClick(element, this);
}
SelectAllObject.prototype.changePage = function() {
	$(this).tableChangePage(this);
}
SelectAllObject.prototype.clearSelectedDatas = function() {
	for ( var i in this.selectedDatas) {
		this.selectedDatas[i] = "";
	}
}