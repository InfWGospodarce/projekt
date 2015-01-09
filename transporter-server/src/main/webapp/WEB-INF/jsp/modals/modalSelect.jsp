<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="${modalId}" class="modal fade">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Zamknij"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title">${modalTitle}</h4>
        </div>
        <div class="modal-body">
          <p>One fine body&hellip;</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
        </div>
      </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}${modalJsPath}"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/main.js"></script>