function creatModal(type, modalId, modalWidth, mainContentId, btnConfirmId, title, messegeText) {   
	if ($('#' + modalId).length > 0) {       
		$('#' + modalId).modal('show');   
	} else {       
		var modal = $('<div>').addClass('modal fade').attr({           
			'id': modalId,
			           'tabindex': '-1',
			           'role': 'dialog',
			           'aria-labelledby': 'myModalLabel',
			           'aria-hidden': 'false',
			           'data-backdrop': 'static'       
		});       
		var modalDialog = $('<div>').addClass('modal-dialog').css({           
			'width': modalWidth       
		});       
		var modalContent = $('<div>').addClass('modal-content');       
		var modalHeader = $('<div>').addClass('modal-header');       
		var closeBtn = $('<button>').addClass('close').attr({           
			'data-dismiss': 'modal',
			           'aria-hidden': 'true',
			       
		});       
		var title = $('<h4>').text(title);       
		modalHeader.append(closeBtn).append(title);       
		var modalBody = $('<div>').addClass('modal-body');       
		if (type == "modalDialog") {           
			modalBody.append($('#' + mainContentId));       
		} else if (type == "messegeDialog") {           
			var labelTex = $('<i>').addClass('icon-notification');           
			var messegeTex = $('<span>').addClass('messege').text(messegeText);           
			modalBody.append(labelTex).append(messegeTex);       
		}       
		var modalFooter = $('<div>').addClass('modal-footer');       
		var btnCancel = $('<button>').addClass('btn btn-default modalBtn').attr({           
			'data-dismiss': 'modal',
			           'id': btnConfirmId       
		});       
		var btnConfirm = $('<button>').addClass('btn btn-default modalBtn').attr({           
			'id': btnConfirmId       
		}).text('确定');       
		if (type == "modalDialog") {           
			btnCancel.text('取消');           
			modalFooter.append(btnConfirm).append(btnCancel);       
		} else if (type == "messegeDialog") {           
			btnCancel.text('知道了');           
			modalFooter.append(btnCancel);       
		}       
		modalContent.append(modalHeader).append(modalBody).append(modalFooter);       
		modalDialog.append(modalContent);       
		modal.append(modalDialog);       
		$('body').append(modal);       
		$('#' + modalId).modal('show');       
		if (type == "modalDialog") {           
			$('#' + mainContentId).show();       
		} else {           
			$('#' + mainContentId).hide();       
		}   
	}
}