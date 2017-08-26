<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="bootstrap-wysihtml5-insert-link-modal modal fade in"
	data-wysihtml5-dialog="createLink"
	style="display: block; padding-right: 17px;">
	<div class="modal-dialog " style = "margin:10px auto;padding-left:5%;padding-top:2%">
		<div class="modal-content">
			<div class="modal-header skin-black navbar {{skin}}">
				<a class="close" data-dismiss="modal" ng-click="cancel();"
					style="color: #333;">×</a>
				<h3 style="text-align: center; color: #fff;">{{title}}</h3>
			</div>
			<div class="modal-body"
				style="display: inline-block; overflow-y: scroll; height: 300px; width:100%" >
				<div class="form-group" >

					<div class="col-xs-6">
						
						<div style="float: left; display: block;">
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='海鲜';" ng-checked = "object.item == '海鲜';"
									id="pb-rd-seafood" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-seafood"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">海鲜</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='鱼虾';" ng-checked = "object.item == '鱼虾';"
										id="pb-rd-fish" name="pb-rd-sex"
										class="jc-query-param-checkbox" type="radio"> <label
										for="pb-rd-fish"
										style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">鱼虾</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='猪肉';" ng-checked = "object.item == '猪肉';"
									id="pb-rd-pork" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-pork"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">猪肉</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='牛羊肉';" ng-checked = "object.item == '牛羊肉';"
									id="pb-rd-beef" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-beef"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">牛羊肉</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='巧克力';" ng-checked = "object.item == '巧克力';"
									id="pb-rd-chocolate" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-chocolate"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">巧克力</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='菠萝';" ng-checked = "object.item == '菠萝';"
									id="pb-rd-pineapple" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-pineapple"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">菠萝</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='木瓜';" ng-checked = "object.item == '木瓜';"
									id="pb-rd-pawpaw" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-pawpaw"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">木瓜</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='荞麦';" ng-checked = "object.item == '荞麦';"
									id="pb-rd-buckwheat" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-buckwheat"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">荞麦</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='葵花籽';" ng-checked = "object.item == '葵花籽';"
									id="pb-rd-sunflower" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-sunflower"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">葵花籽</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='芒果';" ng-checked = "object.item == '芒果';"
									id="pb-rd-mango" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-mango"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">芒果</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='芥末';" ng-checked = "object.item == '芥末';"
									id="pb-rd-mustard" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-mustard"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">芥末</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='花生';" ng-checked = "object.item == '花生';"
									id="pb-rd-peanuts" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-peanuts"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">花生</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='牛奶';" ng-checked = "object.item == '牛奶';"
									id="pb-rd-milk" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-milk"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">牛奶</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='鸡蛋';" ng-checked = "object.item == '鸡蛋';"
									id="pb-rd-egg" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-egg"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">鸡蛋</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='番茄';" ng-checked = "object.item == '番茄';"
									id="pb-rd-tomatoes" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-tomatoes"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">番茄</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='酒精';" ng-checked = "object.item == '酒精';"
									id="pb-rd-alcohol" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-alcohol"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">酒精</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='油漆';" ng-checked = "object.item == '油漆';"
									id="pb-rd-paint" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-paint"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">油漆</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='花粉';" ng-checked = "object.item == '花粉';"
									id="pb-rd-pollen" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-pollen"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">花粉</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='粉尘';" ng-checked = "object.item == '粉尘';"
									id="pb-rd-dust" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-dust"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">粉尘</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='霉菌';" ng-checked = "object.item == '霉菌';"
									id="pb-rd-mycete" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-mycete"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">霉菌</div>
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style="display: block; float: left;">
									<input ng-click="object.item='其他';" 
									id="pb-rd-other" name="pb-rd-sex"
									class="jc-query-param-checkbox" type="radio"> <label
									for="pb-rd-other"
									style="width: 25px; height: 25px;"></label>
								</div>
								<div style="float: left; font-size: 14px; padding: 3px 20px;">其他</div>
								
							</div>
							<div style="display: block; float: left; width: 200px;">
								<div style = "width: 100%">
									<input ng-model="object.item" type="text" class="form-control" placeholder="请输入过敏药物">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal-footer">
				<a class="btn btn-default" href="" ng-click="cancel();">取消</a>
				<a href="" class="btn btn-primary" ng-click="confirm()">确定</a>
			</div>
		</div>
	</div>
</div>