package com.vti.template.program;

import java.util.Scanner;

import com.vti.template.controller.CandidateController;
import com.vti.template.form.CandidateForm;
import com.vti.template.form.ExperienceCandidateForm;
import com.vti.template.form.FresherCandidateForm;
import com.vti.template.utils.MessageUtil;
import com.vti.template.utils.ScannerUtil;

/**
 * This class is .
 * 
 * @Description: .
 * @author: NTHung
 * @create_date: Jan 6, 2020
 * @version: 1.0
 * @modifer: NTHung
 * @modifer_date: Jan 6, 2020
 */

public class Function {
	private CandidateController candidateController;
	private Scanner scanner;

	public Function() {
		candidateController = new CandidateController();
		scanner = new Scanner(System.in);
	}

	public void registerCandidate() {
		// register Experience
		CandidateForm candidateForm = null;
		System.out.println("*************REGISTER EXPERIENCE***************");
		while (true) {

			// input firstName
			System.out.println("Input FirstName: ");
			String firstName = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_FIRSTNAME_FORMAT);
			// input fullName
			System.out.println("Input LastName: ");
			String lastName = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_LASTNAME_FORMAT);

			// input email
			System.out.println("Input email: ");
			String email = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_EMAIL_FORMAT);

			// input password
			System.out.println("Input Password: ");
			String password = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_PASSWORD_FORMAT);

			// phone
			System.out.println("Input Phone");
			String phone = ScannerUtil.readString(scanner, MessageUtil.VALIDATE_PHONE_FORMAT);

			String roleName = null;
			int expInYear = 0;
			String proSkill = null;
			String graduationRank = null;
			while (roleName == null) {
				System.out.println("Mời bạn nhập 1: ExperienceCandidate hoặc 2:FresherCandidate");
				int roleInput = ScannerUtil.readInt(scanner, MessageUtil.VALIDATE_ROLE_FORMAT);
				switch (roleInput) {
				case 1:
					roleName = "ExperienceCandidate";
					// ExpInYear
					System.out.println("Input ExpInYear: ");
					expInYear = ScannerUtil.readInt(scanner, MessageUtil.VALIDATE_EXPINYEAR_FORMAT);

					// proskill
					System.out.println("Input proSkill: ");
					proSkill = ScannerUtil.readString(scanner, "Hãy nhập kỹ năng của bạn ");

					candidateForm = new ExperienceCandidateForm(firstName, lastName, phone, email, password, roleName,
							expInYear, proSkill);
					boolean registerExperience = candidateController
							.registerCandidate((ExperienceCandidateForm) candidateForm);
					if (registerExperience) {
						System.out.println("Create success ");
						break;
					} else {
						System.out.println("Create fail! Exist ExperienceCandidate with email = " + email
								+ "\nPlease! input again!");
					}
					break;
				case 2:
					roleName = "FresherCandidate";

					while (graduationRank == null) {
						System.out.println("Mời bạn nhập xếp loại tốt nghiệp");
						System.out.println("1:Excellence,  2:Good, 3:Fair, 4:Poor  ");
						int graduationRankinput = ScannerUtil.readInt(scanner, "Bạn chỉ có thể nhập");
						switch (graduationRankinput) {
						case 1:
							graduationRank = "Excellence";
							break;
						case 2:
							graduationRank = "Good";
							break;
						case 3:
							graduationRank = "Fair";
							break;
						case 4:
							graduationRank = "Poor";
							break;
						default:
							break;
						}
						candidateForm = new FresherCandidateForm(firstName, lastName, email, password, phone, roleName,
								graduationRank);
						boolean registerFresher = candidateController
								.registerCandidate((FresherCandidateForm) candidateForm);
						if (registerFresher) {
							System.out.println("Create success ");
							break;
						} else {
							System.out.println("Create fail! Exist FresherCandidate with email = " + email
									+ "\nPlease! input again!");
						}
					}
				default:
					break;
				}

			}
		}
	}
}
