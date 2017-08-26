
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row" style="margin-left: 55%; width: 45%;">
	<div>
	<!-- <button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="queryList(1);">新增</button>
	<button ng-show="!pageContent" class="btn btn-info pull-right" style="margin: 10px;" ng-click="queryList(1);">删除</button> -->
	</div>
</div>
<!-- 导航栏 -->


<div id="page-content" ng-show="!pageContent">

	<div class="box box-info">

		<!-- form start -->
		<form class="form-horizontal">
			<div class="box-body" style="width: 100%; display: block;">
				
				<div class="row" style="height: 50px;">
				<ul id="tabButton" style="padding-left:0;"> 
			         <li id="quotaType0" ng-click="quotaType=0;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
						体重BMI
			        </li> 
			        <li id="quotaType1" ng-click="quotaType=1;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
			        	体温
			        </li> 
			        <li id="quotaType2" ng-click="quotaType=2;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
			        	血压
			        </li>
			        <li id="quotaType3" ng-click="quotaType=3;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
			        	血氧
			        </li>
			        <li id="quotaType4" ng-click="quotaType=4;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
			        	血糖
			        </li>
			        <li id="quotaType5" ng-click="quotaType=5;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
			        	心率
			        </li>
			        <li id="quotaType6" ng-click="quotaType=6;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
			        	脂肪率
			        </li>
			        <li id="quotaType7" ng-click="quotaType=7;classChange();"  class='non-active-tabButton' style="cursor:pointer;">
			        	尿检
			        </li>
			        
			       
				</ul> 
			</div>


			</div>
		</form>
	</div>

	<div ng-show="quotaType==0 || quotaType=='0'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">BMI表:</label>
		</div>
		<div class="col-sm-6">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">BMI</th>
						<th class="sorting">标准</th>
						<th class="sorting">超重</th>
						<th class="sorting">轻度肥胖</th>
						<th class="sorting">中度肥胖</th>
						<th class="sorting">重度肥胖</th>
						
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>范围</td>
						<td>18~25</td>
						<td>25~30</td>
						<td>30~35</td>
						<td>35~40</td>
						<td>40以上</td>
					</tr>


				</tbody>

			</table>
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">公式:</label>
		</div>
		<div class="col-sm-6">
			
			体质指数（BMI）=体重（kg）÷身高^2（m）
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">举个例子:</label>
		</div>
		<div class="col-sm-6">
			
			一个人的身高为1.75米,体重为68千克，他的BMI=68/(1.75^2)=22.2（千克/米^2）当BMI指数为18～25时属正常。
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			并不是每个人都适用BMI的，如：
			1. 未满18岁；
			2. 是运动员；
			3. 正在做重量训练；
			4. 怀孕或哺乳中；
			5. 身体虚弱或久坐不动的老人。
			如果认为BMI算出来的结果不能正确反映体重问题，请带着结果与医师讨论，并要求做体脂肪测试。
			
		</div>
	</div>
	</div>
	
	<div ng-show="quotaType==1 || quotaType=='1'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">体温表:</label>
		</div>
		<div class="col-sm-6">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">体温</th>
						<th class="sorting">标准</th>
						<th class="sorting">低热</th>
						<th class="sorting">高热</th>
						
						
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>范围</td>
						<td>36~37</td>
						<td>37.3~38</td>
						<td>38.1~41</td>
						
					</tr>


				</tbody>

			</table>
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">影响因素:</label>
		</div>
		<div class="col-sm-6">
			
			体温并不是固定不变的，可随性别、年龄、昼夜、运动和情绪的变化等因素而有所波动，但这种改变经常在正常范围内。
性别因素
一般女性较男性稍高，女性在月经前期和妊娠早期轻度升高，排卵期较低，这种波动主要与孕激素分泌周期有关， 女性的体内脂肪较男性为高这也应该是一个原因。
年龄因素
新生儿体温易受外界温度的影响而发生变化。因为新生儿中枢神经系统发育尚未完善，皮肤汗腺发育又不完全，从而体温调节功能较差，容易波动。儿童代谢率高，体温可略高于成人。老年人由于代谢率低，故体温偏低。
昼夜因素
一般清晨2－6时体温最低，下4－8时体温最高，其变动范围约在0.5-1℃之间。这种昼夜有规律的波动，是由于人们长期的生活方式如活动、代谢、血液循环等相应的周期性变化所形成的。而长期从事夜间工作者，周期性波动则出现夜间体温升高，日间体温下降的情况。
情绪与运动
情绪激动时交感神经兴奋，运动时骨骼肌收缩，均可使体温略有升高。
此外，外界气温的变化，进食等均可使体温产生波动。
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">测量时间:</label>
		</div>
		<div class="col-sm-6">
			
			人体正常体温的测量方法是在早晨8点左右、午后3点左右、晚上8点左右各测一次体温，连续测量几天，取其最稳定的值即为正常体温。
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			1）测量体温前、后，应清点体温计总数。手甩体温计时要用腕部力量，勿触及他物，以防撞碎。切忌把体温计放入热水中清洗或放在沸水中煮，以防爆裂。
2）根据病人病情选择合适的测量体温的方法：①凡婴幼儿、精神异常、昏迷、口鼻腔手术以及呼吸困难、不能合作的病人，不宜测口腔温度；②凡消瘦不能夹紧体温计、腋下出汗较多者，以及腋下有炎症、创伤或手术的病人不宜使用腋下测温法；③凡直肠或肛门手术、腹泻，以及心肌梗死的病人不宜使用直肠测温法。
3）病人进食、饮水，或进行蒸汽吸入、面颊冷热敷等，须隔30分钟后测口腔温度；腋窝局部冷热敷应隔30分钟再测量腋温；灌肠、坐浴后须隔30分钟，方可经直肠测温。
4）测口温时，当病人不慎咬破体温计时，应立即清除玻璃碎屑，以免损伤唇、舌、口腔、食管及胃肠道的黏膜；口服牛奶或蛋清以延缓汞的吸收；在病情允许的情况下，可服大量粗纤维食物（如韭菜等），以加速汞的排出。
5）凡给婴幼儿、昏迷、危重病人及精神异常者测体温时，应有专人看护，以免发生意外。
6）如发现体温与病情不相符合，应守在病人身旁重新测量，必要时可同时测口温和肛温作对照。
			
		</div>
	</div>
	</div>
	
	<div ng-show="quotaType==2 || quotaType=='2'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">血压:</label>
		</div>
		<div class="col-sm-6">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">情况</th>
						<th class="sorting">理想压</th>
						<th class="sorting">正常压</th>
						<th class="sorting">偏高压</th>
						<th class="sorting">高血压</th>
						<th class="sorting">低血压</th>
						
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>收缩压</td>
						<td>&lt;120mmHg</td>
						<td>90~140mmHg</td>
						<td>130~139mmHg</td>
						<td>&ge; 140mmHg</td>
						<td>&lt;90mmHg</td>
					</tr>
					<tr role="row" class="odd">
						<td>舒张压</td>
						<td>&lt;80mmHg</td>
						<td>60~90mmHg</td>
						<td>85~89mmHg</td>
						<td>&ge; 90mmHg</td>
						<td>&lt;60mmHg</td>
					</tr>


				</tbody>

			</table>
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">人群:</label>
		</div>
		<div class="col-sm-6">
			
			易患高血压人
1.父母、 兄弟、姐妹等家属有高血压病史者
2.肥胖者
3.过分摄入盐分者
4.过度饮酒者
5.神经质易焦躁者
易患低血压人
1.青年女性
2.长期卧床休息者
3.病后初愈者
4.体质瘦弱者
5.更年期妇女
6.老年人群
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">公式:</label>
		</div>
		<div class="col-sm-6">
			
			KPa：千帕，通常用于表示血压数值。
mmHg：毫米汞柱，用水银血压计来测量血压时用水银柱的高度“毫米汞柱”来表示血压的水平。
1mmHg（毫米汞柱）=0.133kPa（千帕斯卡）
7.5mmHg（毫米汞柱）=1kPa（千帕斯卡）
			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			世界卫生组织（WHO）于1978 年提出高血压病的药物“阶梯治疗”方案。这方案具有治疗简化、副作用减少，对患者因病施治，针对性强的特 点 。用药先从单一或简单的给药方式开始，疗效不大或无效时，再逐步增加其它药物。
第一步：利尿剂（如双氢克尿塞）从排钠和减低血容量着手，或用β-受体阻滞剂（如心得安）以减低心肌收缩力、减慢心率、减低心搏出量，以达到降压目的，若无效，则进行第二步治疗。
第二步：可同时用两种药物治疗，利尿剂加β-受体阻滞剂，或用其中的任何一种，另加其它一种降压药如利血平等。利尿剂加利血平，或利 尿剂加甲基多巴，或利尿剂加可乐宁，或β-受体阻滞剂（如心得安，或美多心安）加肼苯哒嗪。如仍无效，则进行第三步治疗。
第三步：同时应用4种药物，利尿剂加β-受体阻滞剂，加血管扩张剂，再加其他降压药如长压定。
在治疗中，血压得到适当控制，经一段时间巩固后，可试行减药，即逐步“下阶梯”的方法，直减至最少的药物及最小的剂量，且仍使血压 稳 定，得到适用于每个病人的药物量，同时亦减少了药物的副作用，疗效可达个体最佳水准。本阶梯疗法适用于无合并症的病人。[1] 
第四步：同时应用3种药物，如利尿剂加β-受体阻滞剂加血管扩张剂（如阱苯哒嗪），若再无效，可改为第四步治疗。
			
		</div>
	</div>
	</div>
	
	<div ng-show="quotaType==3 || quotaType=='3'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">血氧:</label>
		</div>
		<div class="col-sm-6">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">情况</th>
						<th class="sorting">正常</th>
						<th class="sorting">供氧不足</th>
						<th class="sorting">低氧血症</th>
						<th class="sorting">有误差</th>
						
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>动脉血氧饱和度</td>
						<td>94%～97%</td>
						<td>90%~94%</td>
						<td>70%~90%</td>
						<td>&lt;70%</td>
					</tr>
					
					

				</tbody>

			</table>
			
		</div>
		
	</div>
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">介绍:</label>
		</div>
		<div class="col-sm-6">
			是指血红蛋白与氧结合达到饱和程度的百分数。1克血红蛋白最多能与1.36毫升的氧结合，氧饱和度达到100%。
			一般认SpO2正常应不低于94%，在94%以下为供氧不足。有学者将SpO2<90%定为低氧血症的标准，并认为当SpO2高于70%时准确性可达±2%，SpO2低于70%时则可有误差。临床 上我们曾对数例病人的SpO2数值，与动脉血氧饱和度数值进行对照，认为SpO2读数可反 映病人的呼吸功能，并在一定程度上反映动脉血氧的变化。胸外科术后病人除个别病例临床 症状与数值不符需作血气分析外，常规应用脉搏血氧饱和度监测，可为临床观察病情变化提 供有意义的指标，避免了病人反复采血，也减少护士的工作量，值得推广。 临床一般大于90%就可以了，当然要对不同的科室。
			
		</div>
	</div>
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">公式:</label>
		</div>
		<div class="col-sm-6">
			
			氧饱和度（%）=实际1克血红蛋白结合的氧（毫升）/1.36（毫升）×100
			
		</div>
	</div>
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			缺氧对机体有着巨大的影响。比如对CNS，肝、肾功能的影响。低氧时首先出现的是代偿性心率加速，心搏及心排血量增加，循环系统以高动力状态代偿氧含量的不足。同时产生血流再分配，脑及冠状血管选择性扩张以保障足够的血供。但在严重的低氧状况时，由于心内膜下乳酸堆积，ATP合成降低，产生心肌抑制，导致心动过缓，期前收缩，血压下降与心排血量降低，以及出现室颤等心率失常乃至停搏。
			
		</div>
	</div>
	</div>
	
	<div ng-show="quotaType==4 || quotaType=='4'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">血糖:</label>
		</div>
		<div class="col-sm-6">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">情况</th>
						<th class="sorting">标准</th>
						<th class="sorting">糖尿病</th>
						<th class="sorting">糖耐量受损</th>
						<th class="sorting">空腹血糖受损</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>空腹</td>
						<td>4.4~6.1mmol/L</td>
						<td>&ge; 6.1mmol/L</td>
						<td>&lt;6.1mmol/L</td>
						<td>5.6~6.1mmol/L</td>
						
					</tr>
					<tr role="row" class="odd">
						<td>餐后2小时</td>
						<td>4.4~8.0mmol/L</td>
						<td>&ge; 10.0mmol/L</td>
						<td>6.7~10.0mmol/L</td>
						<td>&lt;6.7mmol/L</td>
					</tr>


				</tbody>

			</table>
			
		</div>
	</div>
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">公式:</label>
		</div>
		<div class="col-sm-6">
			
			血糖单位换算：1 mmol/L=18 mg/dl
空腹：指停止摄入含热量食物8小时以上
餐后2小时：指从进食第一口开始计算两小时后

			
		</div>
	</div>
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			■ 血糖控制差的病人或病情危重者应每天监测8次，直到病情稳定，血糖得到控制。当病情稳定或已达血糖控制目标时可每周监测1-2次。
■ 使用胰岛素治疗者在治疗开始阶段每日至少测血糖5次，达到治疗目标后每日自我监测血糖2-4次。
■ 使用口服药和生活方式干预的患者每周监测血糖2-4次。
血糖监测时间：
■ 餐前血糖检测，当血糖水平很高时空腹血糖水平是首先要关注的，有低血糖风险者（老年人，血糖控制较好者）也应测定餐前血糖。
■ 餐后2小时血糖监测适用于空腹血糖已获良好控制但仍不能达到治疗目标者。
■ 睡前血糖监测适用于注射胰岛素的患者，特别是注射中长效胰岛素的患者。
■ 夜间血糖监测适用于胰岛素治疗已接近治疗目标而空腹的血糖。
■ 出现低血糖症状时应及时检测血糖。
■ 剧烈运动前宜监测血糖。

			
		</div>
	</div>
	</div>
	
	<div ng-show="quotaType==5 || quotaType=='5'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">心率:</label>
		</div>
		<div class="col-sm-6">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">情况</th>
						<th class="sorting">房室传导阻滞</th>
						<th class="sorting">窦性心动过缓</th>
						<th class="sorting">正常</th>
						<th class="sorting">窦性心动过速</th>
						<th class="sorting">阵发性心动过速</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>心率</td>
						<td>0-40次/分</td>
						<td>40-60次/分</td>
						<td>60-100次/分 </td>
						<td>100-160次/分</td>
						<td>160-200次/分</td>
					</tr>

				</tbody>

			</table>
			
		</div>
	</div>
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			很多人都会有窦性心动过缓伴不齐，对于多数人来说是正常的，不必过于担心。窦性心动过缓是指心率低于60次/分钟的人，是否会出现此症状，与其心跳过缓的频率和引起心跳过缓的原因有关。在安静状态下，成年人的心率若在50～60次/分钟之间一般不会出现明显症状。尤其是一些训练有素的运动员以及长期从事体力劳动的人，在安静状态下即使其心率在40次/分钟左右也不会出现明显症状。但是一般人的心率若在40～50次/分钟之间，就会出现胸闷、乏力、头晕等症状，若其心率降至35～40次/分钟则会发生血流动力学改变，使心脑器官的供血受到影响，从而出现胸部闷痛、头晕、晕厥甚至猝死。如果自我感觉没有任何不适，不用去理会心电图所说的“窦性心动过缓伴不齐”，但如果出现胸闷、乏力、头晕等不适症状，应立即到医院进一步检查，比如动态心电图、心脏彩超等检查，了解心动过缓的病因，如果心跳过慢，可以通过安装心脏起搏器缓解症状，改善预后。

			
		</div>
	</div>
	</div>
	
	<div ng-show="quotaType==6 || quotaType=='6'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">脂肪率:</label>
		</div>
		<div class="col-sm-6">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">情况</th>
						<th class="sorting">偏瘦</th>
						<th class="sorting">标准</th>
						<th class="sorting">微胖</th>
						<th class="sorting">肥胖</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>30岁以下男性</td>
						<td>13%以下</td>
						<td>14%~20%</td>
						<td>21%~25% </td>
						<td>25%以上</td>
					</tr>
					<tr role="row" class="odd">
						<td>30岁以上男性</td>
						<td>16%以下</td>
						<td>17%~23%</td>
						<td>24%~25%</td>
						<td>25%以上</td>
					</tr>
					<tr role="row" class="odd">
						<td>30岁以下女性</td>
						<td>16%以下</td>
						<td>17%~24%</td>
						<td>25%~30% </td>
						<td>30%以上</td>
					</tr>
					<tr role="row" class="odd">
						<td>30岁以上女性</td>
						<td>19%以下</td>
						<td>20%~27%</td>
						<td>28%~30% </td>
						<td>30%以上</td>
					</tr>

				</tbody>

			</table>
			
		</div>
	</div>
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">公式:</label>
		</div>
		<div class="col-sm-6">
			
			①BMI=体重（公斤）÷（身高×身高）（米）
②体脂率：1.2×BMI+0.23×年龄-5.4-10.8×性别（男为1，女为0）
			
		</div>
	</div>
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			肥胖 ≠ 体重过重

			
		</div>
	</div>
	</div>
	
	
	<div ng-show="quotaType==7 || quotaType=='7'">
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">尿常规:</label>
		</div>
		<div class="col-sm-12">
			
			<table id="example2"
				class="table table-bordered table-hover dataTable" role="grid"
				aria-describedby="example2_info">
				<thead>
					<tr role="row">
						<th class="sorting">情况</th>
						<th class="sorting">尿蛋白（PR0）</th>
						<th class="sorting">尿白细胞(U—LEU)</th>
						<th class="sorting">尿酮体(U-Ket)</th>
						<th class="sorting">尿亚硝酸盐(NIT)</th>
						<th class="sorting">尿胆原(URO或UBG)</th>
						<th class="sorting">尿胆红素(U-BIL)</th>
						<th class="sorting">尿蛋白（PRO）</th>
						<th class="sorting">尿糖（GLU）</th>
						<th class="sorting">尿比重(SG)</th>
						<th class="sorting">尿酸碱度</th>
						<th class="sorting">隐血BLO</th>
						<th class="sorting">酮体（KET）</th>
						<th class="sorting">尿红细胞（RBC）</th>
						<th class="sorting">尿液颜色（GOL）</th>
						<th class="sorting">维C</th>
						<th class="sorting">尿肌酐</th>
					</tr>
				</thead>
				<tbody>

					<tr role="row" class="odd">
						<td>正常</td>
						<td>阴性或仅有微量</td>
						<td>&lt;5个/HP</td>
						<td>阴性 </td>
						<td>阴性</td>
						<td>&lt;16</td>
						<td>阴性 </td>
						<td>阴性</td>
						<td>阴性 </td>
						<td>1.015~1.025</td>
						<td>4.6~8.0 </td>
						<td>阴性</td>
						<td>阴性 </td>
						<td>阴性</td>
						<td>浅黄色至深黄色 </td>
						<td>阴性</td>
						<td>40-130 mg/dl</td>
					</tr>
					<tr role="row" class="odd">
						<td>不正常</td>
						<td>阳性</td>
						<td>&ge;5个/HP</td>
						<td>阳性 </td>
						<td>阳性</td>
						<td>&ge;16</td>
						<td>阳性</td>
						<td>阳性</td>
						<td>阳性 </td>
						<td>&lt;1.015或&ge;1.025</td>
						<td>&lt;4.6或&ge;8.0 </td>
						<td>阳性</td>
						<td>阳性 </td>
						<td>阳性</td>
						<td>黄绿色、尿浑浊、血红色 </td>
						<td>阳性</td>
						<td>&lt;40mg/dl或&ge;130mg/dl</td>
					</tr>
					

				</tbody>

			</table>
			
		</div>
	</div>
	
	
	
	<div class="row">
		<div class="form-title">
					<label class="fn-title control-label">注意事项:</label>
		</div>
		<div class="col-sm-6">
			
			尿标本留取时应注意一些特殊情况：
①女性患者应避免在月经期内留取尿液标本；
②肉眼血尿标本不应进行尿液检查（尿沉渣除外）；
③如果服用的药物影响尿液检查，应在停药后留取标本；
④如果是乳糜尿，应嘱咐患者待尿液澄清后留取。

			
		</div>
	</div>
	</div>

</div>



