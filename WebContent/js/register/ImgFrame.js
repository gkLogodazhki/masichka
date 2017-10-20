$('#change-profile-pic').on('click', function(e) {
	$('#profile_pic_modal').modal({
		show : true
	});
});

$('#profile-pic').on('change', function() {
	$("#preview-profile-pic").html('');
	$("#preview-profile-pic").html('Uploading....');
	$("#cropimage").ajaxForm({
		target : '#preview-profile-pic',
		success : function() {
			jQuery('img#photo').imgAreaSelect({
				aspectRatio : '1:1',
				onSelectEnd : getSizes,
			});
			$('#image_name').val(jQuery('#photo').attr('file-name'));
		}
	}).submit();
});